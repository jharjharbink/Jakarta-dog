<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/07/2024
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="dog" scope="request" type="org.example.dogs.model.Dog" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <p>id: <%= dog.getId() %></p>
    <p>nom: <%= dog.getName() %></p>
    <p>race: <%= dog.getRace() %></p>
    <p>date de naissance: <%= dog.getBirthDate() %></p>
</body>
</html>
