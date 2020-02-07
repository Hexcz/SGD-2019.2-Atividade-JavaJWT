<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 06/02/2020
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/assets/index.css"/>
    <meta http-equiv="Content-Type">
    <title>Exemplo Java/JWT - Página Inicial</title>
</head>
<body>
<form id="formImg">
    <table id="tabela">

        <tr>
            <td><center><h5 id="texto2">Olá ${usuario}!</h5></center></td>
        </tr>
        <tr>
            <td><center><h3 id="texto">Veja esta imagem e melhore seu dia!</h3></center></td>
        </tr>
        <tr>
            <td><center><img src="resources/media/sunset.jpg"></center></td>
        </tr>
    </table>
    </form>
</body>
</html>