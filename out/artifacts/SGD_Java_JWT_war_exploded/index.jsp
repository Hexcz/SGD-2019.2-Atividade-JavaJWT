<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 04/02/2020
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="resources/assets/index.css"/>
  <meta http-equiv="Content-Type">
  <title>Exemplo Java/JWT - Login</title>
</head>
<body>
<form action="Login" method="post">
  <table id="tabela">

    <tr>
      <h3 id="texto">${mensagem}</h3>
    </tr>
    <tr>
      <td><input type="text" name="usuario" placeholder="Usuário" required/></td>
    </tr>
    <tr>
      <td><input type="password" name="senha" placeholder="Senha" required/></td>
    </tr>
  </table>
  <input type="submit" value="Login" />
  <p id="texto">Ou <a href="cadastro.jsp">cadastre-se!</a></p></form>
</body>
</html>