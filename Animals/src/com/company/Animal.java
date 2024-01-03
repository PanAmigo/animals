package com.company;

import java.time.LocalDate;

public class Animal {
    private String Name;
    private String Species;
    private LocalDate birthDate;

    public Animal(String name, String species, LocalDate birthDate) {
        Name = name;
        Species = species;
        this.birthDate = birthDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAnimal(){
        String data= Name + " " + Species + " " + birthDate.toString();
        return data;
    }
}
