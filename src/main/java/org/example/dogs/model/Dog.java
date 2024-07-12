package org.example.dogs.model;

import java.time.LocalDate;

public class Dog {
    private long id;
    private String name;
    private String race;
    private LocalDate birthDate;

    public Dog(long id, String name, String race, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
