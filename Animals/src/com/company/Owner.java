package com.company;

import com.company.Animal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class Owner {

    private String Firstname;
    private String Surname;
    private String Address;
    private ArrayList<Animal> animals;


    public Owner(String firstname, String surname, String address) {
        Firstname = firstname;
        Surname = surname;
        Address = address;
        animals = new ArrayList<Animal>();
    }

    public void PrintOwner()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String zwierzaki = "";
        try{
            if (animals.size() > 0) {
                zwierzaki = "Zwierzaki: \n";

                for(int i=0; i < 4; i++){
                    zwierzaki += animals.get(i).getAnimal();
                }
            }
            else {
                zwierzaki = "Brak przypisanych zwierząt";
            }
        }
        catch (Exception e ){
            System.out.println(e);
        }

        String data = getFirstname() + " " + getSurname() + " " + getAddress() + "\n " + zwierzaki;
        System.out.println(data);
    }

    public void PrintAnimals()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String zwierzaki = "";
        try{
            if (animals.size() > 0) {
                zwierzaki = "Zwierzaki: \n";

                for(int i=0; i < animals.size(); i++){
                    zwierzaki += animals.get(i).getAnimal();
                }

                String data = zwierzaki;
                System.out.println(data);
            }
        }
        catch (Exception e ){
            System.out.println(e);
        }
    }
    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void PrintAnimalsName()
    {
        try{
            if (animals.size() > 0) {
                for(int i=0; i < animals.size(); i++){
                    System.out.println(animals.get(i).getName());
                }
            }
        }
        catch (Exception e ){
            System.out.println(e);
        }
    }

    public int getNumberOfAnimals(){
        return animals.size();
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
}
