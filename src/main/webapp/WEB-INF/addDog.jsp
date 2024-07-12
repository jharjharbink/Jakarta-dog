<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/07/2024
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire</title>
    <title>l'amical des chiens</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous">
    </script>
</head>
<body>
<h1>Nouveau Chien</h1>
<hr>
<form action="dog/list/" method="post">
    <div>
        <label for="name">Nom :</label>
        <input type="text" id="name" name="nom" >
    </div>
    <div>
        <label for="race">Race :</label>
        <input type="text" id="race" name="race" >
    </div>
    <div>
        <label for="birthDate">Date de naissance :</label>
        <input type="date" id="birthDate" name="date_de_naissance" >
    </div>
    <button>Ajouter</button>
</form>

    </table>
</div>

</body>
</html>
