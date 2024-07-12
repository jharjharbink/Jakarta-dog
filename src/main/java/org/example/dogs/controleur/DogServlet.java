package org.example.dogs.controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dogs.controleur.util.UsefullMethods;
import org.example.dogs.model.Dog;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "dogservlet",value = "/dog/*")
public class DogServlet extends HttpServlet {
    private List<Dog> dogs;

    @Override
    public void init() throws ServletException {
        dogs = new ArrayList<>();
        dogs.add(new Dog(42,"rantanplan","toutou", LocalDate.now()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        System.out.println(action);
        switch (action){
            case "list" :
                showAll(req,resp);
                break;
            case "add" :
                showForm(req,resp);
                break;
            default:
                showDetail(req,resp);
                break;
        }
    }

    protected void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dogs", dogs);
        req.getRequestDispatcher("/WEB-INF/dog/list.jsp").forward(req,resp);
    }
    protected void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/dog/add.jsp").forward(req,resp);
    }
    protected void showDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idRecup = req.getParameter("id");
        req.setAttribute("id",idRecup);
        req.getRequestDispatcher("/WEB-INF/dog/view.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        System.out.println("pathInfo: " + pathInfo);

        long id =  UsefullMethods.setDogId(dogs);
        String name =  req.getParameter("nom");
        String race =  req.getParameter("race");
        LocalDate birthDate = LocalDate.parse(req.getParameter("date_de_naissance"));

        Dog newDog = new Dog(id, name, race, birthDate);
        dogs.add(newDog);
        req.setAttribute("dogs", dogs);
        req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req,resp);
    }
}

/*
inclure un fichier
<%@include file="madiv.html"%>
 */


/* l'affichage des chiens


<div class="container">
    <h1>Liste des chats</h1>
    <hr>
    <table class="table table-dark text-center align-middle">
        <thead>
        <tr>
            <th>#</th>
            <th>Nom</th>
            <th>Race</th>
            <th>Repas Favoris</th>
            <th>Date de naissance</th>
        </tr>
        </thead>
        <tbody>
        <% for (int i = 0; i < dogs.size(); i++) { %>
        <tr>
            <td><%= i+1 %></td>
            <td><%= dogs.get(i).getName() %></td>
            <td><%= dogs.get(i).getRace() %></td>
            <td><%= dogs.get(i).getFavoriteMeal() %></td>
            <td><%= dogs.get(i).getBirthDate() %></td>

        </tr>
        <% } %>
        </tbody>
 */


/*
<jsp:useBean id="dogs" scope="request" type="java.util.ArrayList<org.example.dogs.model.Dog>" />
 */