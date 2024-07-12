<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/07/2024
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="dogs" scope="request" type="java.util.ArrayList<org.example.dogs.model.Dog>" />
<html>
<head>
    <title>Title</title>
    <title>l'amical des chiens</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous">
    </script>
</head>
<body>
    <div class="container">
        <h1>Liste des Chiens</h1>
        <hr>
        <table class="table table-dark text-center align-middle">
            <thead>
            <tr>
                <th>#</th>
                <th>Nom</th>
                <th>Race</th>
                <th>Détail</th>
            </tr>
            </thead>
            <tbody>
            <% for (int i = 0; i < dogs.size(); i++) { %>
            <tr>
                <td><%= dogs.get(i).getId() %></td>dogs.ge
                <td><%= dogs.get(i).getName() %></td>
                <td><%= dogs.get(i).getRace() %></td>
                <td>
                    <a class="btn btn-primary" href="dog/"+i role="button">Détail</a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
