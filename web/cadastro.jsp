<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 05/02/2020
  Time: 00:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/assets/index.css"/>
    <meta http-equiv="Content-Type">
    <title>Exemplo Java/JWT - Cadastro</title>
</head>
<body>
<form action="Cadastro" method="post">
    <table id="tabela">
        <tr>
            <td><input type="text" name="usuario" placeholder="Nome de Usuário"/></td>
        </tr>
        <tr>
            <td><input id="senha" type="password" name="senha" placeholder="Senha"/></td>
        </tr>
        <tr>
            <td><input id="confirmarSenha" type="password" name="confirmarSenha" placeholder="Confirme a Senha"/></td>
        </tr>
    </table>
    <input type="submit" value="Criar conta" />
    <p id="texto"><a href="index.jsp">Cancelar</a></p></form>
</body>
<script type="text/javascript" src="resources/assets/index.js"></script>
</html>