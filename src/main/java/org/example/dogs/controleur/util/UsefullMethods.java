package org.example.dogs.controleur.util;


import org.example.dogs.model.Dog;

import java.util.List;

public class UsefullMethods {

    public static long setDogId(List<Dog> dogs){
        return (long) dogs.size() + 1;
    }
}
