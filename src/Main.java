

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws InterruptedException, NullPointerException {
        String selectDrink;
        String typeOfTea;
        double totalOfCoins;
        double drinkCost;
        double change;
        boolean on = true;


        HashMap<String, Double> drinks = new HashMap<>();
        drinks.put("Latte", 3.00);
        drinks.put("Black Coffee", 1.50);
        drinks.put("White Coffee", 2.00);
        drinks.put("Tea", 1.20);

        ArrayList<String> ourDrinks = new ArrayList<>();
        ourDrinks.add("Latte - 3.00 Eur");
        ourDrinks.add("Black Coffee - 1.50 Eur");
        ourDrinks.add("White Coffee - 2.00 Eur");
        ourDrinks.add("Tea - 1.20 Eur");

        ArrayList<String> tea = new ArrayList<>();
        tea.add("Green");
        tea.add("Fruit");
        tea.add("Black");

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        while (on) {

            System.out.println("Welcome to coffee machine Mx2.\nPlease select your drink:");

            for (String str : ourDrinks) {
                System.out.println((str));
            }
            selectDrink = input.nextLine();

            switch (selectDrink) {
                case "Latte":
                case "White Coffee":
                case "Black Coffee":
                    break;
                case "Tea":
                    for (String str : tea) {
                        System.out.println(str);
                    }
                    System.out.println("Please choose your tea:");
                    typeOfTea = input2.nextLine();
                    System.out.println("You selected:\t" + typeOfTea.toLowerCase() + " tea");
                    break;
                default:
                    System.out.println("Nope... we don't have this drink: " + selectDrink);
            }


            drinkCost = drinks.get(selectDrink);
            System.out.println("Your drink cost: " + drinkCost + " Eur");
            System.out.println("Please insert coin:");
            totalOfCoins = input2.nextDouble();
            while (totalOfCoins < drinkCost) {
                System.out.println("Remaining amount " + (drinkCost - totalOfCoins) + " Eur");
                totalOfCoins += input2.nextDouble();
            }
            if (totalOfCoins > drinkCost) {
                System.out.println("Calculating...");
                change = (drinkCost - totalOfCoins);
                Thread.sleep(1000);
                System.out.println("Please take your change\t" + String.format("%.2f", change) + " Eur");
            }
            Thread.sleep(1000);
            System.out.println(selectDrink + " is preparing...");

            for (int i = 0; i < 30; i++) {

                System.out.print("*");
                Thread.sleep(100);
            }


            System.out.println("\nFinished, please take your drink.");
            for (int i = 0; i < 35; i++) {

                System.out.print("_");

            }

            Thread.sleep(1000);
            System.out.println("\nWould you like another one? (y/n)");
            selectDrink = input.nextLine();
            if (!selectDrink.equals("y")) {
                on = false;
                System.out.println("bye bye");
            }


        }


    }
}

//TODO: Kavos aparato programa
//
//Kavos aparatas gamina:
//- late (3 eur);
//- juodą kavą (1.50 eur);
//- baltą kavą (2 eur);
//- arbatą (1.20 eur).
//Vartotojas, norėdamas nusipirkti norimą produktą, turi įvesti gaminio pavadinimą, tada įdėti grynų pinigų (aparatas atiduoda gražą).
//Jeigu vartotojas pasirenka arbatą, tada aparatas dar paklausia kokios pageidauja:
//- žalios;
//- vaisinės;
//- juodos.
//Pagaminęs produktą aparatas paklausia ar norės kartoti? Jeigu norės, prasideda viskas iš pradžių, priešingu atveju- padėkoja ir palinki gražios dienos.
//
//Įvedimo/ išvedimo pavyzdžiai:
//pirmas pavyzdys
//[Sistemos pranešimas] Sveiki. Čia kavos aparato programa. Prašome įvesti iš sarašo (duotas aukščiau) norimą produktą:
//[Vartotojas įveda] balta kava
//[Sistemos pranešimas] balta kava kainuoja 2 eurus. Prašome įdėti pinigus.
//[Vartotojas įveda] 1.80
//[Sistemos pranešimas] per maža suma. Prašome įvesti reikiamą sumą.
//[Vartotojas įveda] 5
//[Sistemos pranešimas] balta kava kainuoja 2 eurus. Atiduodu 3 eur grąžą.
//[Sistemos pranešimas] prašome palaukti- gaminamas užsakymas.
//[Sistemos pranešimas] prašome pasiimti
//[Sistemos pranešimas] ar norėsite pakartoti?
//[Vartotojas įveda] Taip (ir vėl viskas iš pradžių)
//
//antras pavyzdys
//[Sistemos pranešimas] Sveiki. Čia kavos aparato programa. Prašome įvesti iš sarašo (duotas aukščiau) norimą produktą:
//[Vartotojas įveda] arbata
//[Sistemos pranešimas] arbata kainuoja 1.2 eur. Prašome įdėti pinigus.
//[Vartotojas įveda] 1.20
//[Sistemos pranešimas] kokios arbatos pageidausite? (išvardinamas sąrašas).
//[Vartotojas įveda] žalia
//[Sistemos pranešimas] prašome palaukti- gaminamas užsakymas.
//[Sistemos pranešimas] prašome pasiimti
//[Sistemos pranešimas] ar norėsite pakartoti?
//[Vartotojas įveda] Ne
//[Sistemos pranešimas] Ačiū, kad pirkote. Gražios dienos