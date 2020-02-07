package com.ifpb.sgd.model;
import com.ifpb.sgd.domain.UsuarioLogado;
import com.ifpb.sgd.security.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Login")

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        if (usuario.isEmpty() || senha.isEmpty()) {
            RequestDispatcher req = request.getRequestDispatcher("index.jsp");
            req.include(request, response);
        } else {
            Response loginReq = login(usuario, senha);
            if(loginReq.hasEntity()){
                request.setAttribute("usuario", usuario);
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
            }
            else{
                request.setAttribute("mensagem", "Credenciais incorretas!");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        }
    }

    @POST
    @Path("/Login")
    public Response login(String usuario, String senha) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM usuario WHERE login = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                if (usuario.equals(resultSet.getString("login")) && senha.equals(resultSet.getString("senha"))) {
                    String token = JWTUtil.create(resultSet.getString("login"));
                    UsuarioLogado usuarioLogado = new UsuarioLogado();
                    usuarioLogado.setUsuario(resultSet.getString("login"));
                    usuarioLogado.setToken(token);
                    stmt.close();
                    conn.close();
                    return Response.ok().entity(usuarioLogado).build();
                } else {
                    stmt.close();
                    conn.close();
                    return Response.status(Response.Status.UNAUTHORIZED).build();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}