package com.ifpb.sgd.model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/Cadastro")

public class Cadastro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        if(usuario.isEmpty() || senha.isEmpty()){
            RequestDispatcher req = request.getRequestDispatcher("cadastro.jsp");
            req.include(request, response);
        }
        else{
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            try {
                String sql = "INSERT INTO usuario VALUES (?,?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1,usuario);
                stmt.setString(2,senha);
                stmt.executeUpdate();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            finally {
                try{
                    stmt.close();
                    conn.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("mensagem", "Cadastro realizado com sucesso!");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

}
