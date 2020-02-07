package com.ifpb.sgd.model;

import com.ifpb.sgd.domain.UsuarioLogado;
import com.ifpb.sgd.security.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@WebServlet("/Auth")

public class Auth {
    @GET
    @Path("/Auth")
    public UsuarioLogado usuarioLogado(@Context HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader(JWTUtil.TOKEN_HEADER);
        Jws<Claims> jws = JWTUtil.decode(token);
        UsuarioLogado usuarioLogado = new UsuarioLogado();
        usuarioLogado.setUsuario(jws.getBody().getSubject());
        return usuarioLogado;
    }
}
