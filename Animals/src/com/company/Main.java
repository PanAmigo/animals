package com.company;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        ArrayList<Owner> lista = new ArrayList<Owner>();

        if(lista.size()<5)
        {
            for(int i = 0; i < 5; i++)
            {
                lista.add(GetOwners());
            }
        }

        int wybor = ShowMenu();

        while (wybor != 0){
            switch(wybor){
                case 1:
                    ShowAllOwners(lista);
                    break;
                case 2:
                    ShowAllAnimalsNames(lista);
                    break;
                case 3:
                    AddAnimal(lista);
                    break;
                case 4:
                    ShowInfoAnimals(lista);
                    break;
            }
            System.out.println("\nWciśnij Enter, aby kontynuować...");
            System.in.read();

            wybor = ShowMenu();
        }
        System.out.println("     ****************************************");
    }

    public static Owner GetOwners()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie właściciela:");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko właściciela:");
        String surname = scanner.nextLine();
        System.out.println("Podaj adres właściciela:");
        String address = scanner.nextLine();

        return new Owner(name,surname,address);
    }
    public static int ShowMenu()
    {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Wyświetl właścicieli wraz ze zwierzętami");
        System.out.println("     2. Wyświetl listę wszystkich zwierząt");
        System.out.println("     3. Dodaj zwierzę dla wybranego właściciela");
        System.out.println("     4. Wyświetl informacje o zwierzętach");
        System.out.println("     5. Zakończ program");

        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    public static void ShowAllOwners(ArrayList<Owner> lista)
    {
        lista.forEach(Owner::PrintOwner);
    }
    public static void ShowAllAnimals(ArrayList<Owner> lista)
    {
        lista.forEach(Owner::PrintAnimals);
    }
    public static void ShowAllAnimalsNames(ArrayList<Owner> lista)
    {
        lista.forEach(Owner::PrintAnimalsName);
    }
    public static void AddAnimal(ArrayList<Owner> lista)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie właściciela:");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko właściciela:");
        String surname = scanner.nextLine();

        Owner klient =lista.stream()
                .filter(owner -> name.equals(owner.getFirstname()))
                .filter(owner -> surname.equals(owner.getSurname()))
                .findAny()
                .orElse(null);


        System.out.println("Podaj imie zwierzaka:");
        String name_of_pet = scanner.nextLine();
        System.out.println("Podaj gatunek zwierzaka:");
        String species = scanner.nextLine();
        System.out.println("Podaj date urodzenia zwierzaka w formacie rrrr-mm-dd:");
        String birthDate = scanner.nextLine();

        LocalDate date = LocalDate.parse(birthDate);

        Animal animal = new Animal(name_of_pet,species, date);


        assert klient != null;
        klient.addAnimal(animal);

        System.out.println("Dodano zwierzaka");
    }

    public static void ShowInfoAnimals(ArrayList<Owner> lista){
        int number = lista.stream().mapToInt(Owner::getNumberOfAnimals).sum();
        System.out.println("Liczba zwierząt to: " + number);

        LocalDate date = LocalDate.of(2019,1,1);
        LocalDate date2 = LocalDate.of(2010,1,1);

        AtomicLong temp= new AtomicLong();
        AtomicReference<String> imie = new AtomicReference<>("");

        lista.forEach(owner -> {
            temp.addAndGet(owner.getAnimals().stream().filter(animal -> animal.getBirthDate().isAfter(date)).count());
            imie.set(owner.getAnimals().stream().filter(animal -> animal.getBirthDate().isAfter(date)).toString());
        });

       ArrayList<Animal> zwierzaki = new ArrayList<>();

        lista.forEach(owner -> {
           zwierzaki.add((Animal) owner.getAnimals().stream().filter(animal -> animal.getBirthDate().isAfter(date2)));
        });

        zwierzaki.sort(Comparator.comparing(Animal::getBirthDate));

        System.out.println(temp);
        System.out.println(imie);
        //System.out.println(zwierzaki.get(0).getName());

    }
}
