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


@WebServlet("/dog/*")
public class DogServlet extends HttpServlet {

    private List<Dog> dogs;

    @Override
    public void init(){
        dogs = new ArrayList<>();
        dogs.add(new Dog(UsefullMethods.setDogId(dogs),"Medodor","Berger do Mordor", LocalDate.now()));
        dogs.add(new Dog(UsefullMethods.setDogId(dogs),"Medudur","Berger du Murdur", LocalDate.now()));
        dogs.add(new Dog(UsefullMethods.setDogId(dogs),"Mididir","Birgir di Mirdir", LocalDate.now()));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo();
        System.out.println("pathInfo: " + pathInfo);

        switch (pathInfo) {
            case ("/list/"):
                req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
                break;
            case ("/add/"):
                req.getRequestDispatcher("/WEB-INF/addDog.jsp").forward(req, resp);
                break;
            default:
                long id = Long.parseLong(pathInfo);
                Dog dog = null;

                for (Dog d : dogs)
                    if (d.getId() == id)
                        dog = d;
                        req.setAttribute("dog", dog);
                        req.getRequestDispatcher("/WEB-INF/view.jsp").forward(req,resp);

                //if (dog == null)


        }
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