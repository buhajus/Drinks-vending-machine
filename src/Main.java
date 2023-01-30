import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String selectDrink;
        String typeOfTea;
        double totalOfCoins;
        double drinkCost;
        double change;
        boolean on = true;
        int count = 0;


        HashMap<String, Double> drinks = new HashMap<>();
        drinks.put("Latte", 3.00);
        drinks.put("Black Coffee", 1.50);
        drinks.put("White Coffee", 2.00);
        drinks.put("Tea", 1.20);

        ArrayList<String> tea = new ArrayList<>();
        tea.add("Green");
        tea.add("Fruit");
        tea.add("Black");
        tea.add("Vegan free");

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        while (on) {
            System.out.println("Welcome to coffee machine Mx2.\nPlease select your drink:");

            for (String i : drinks.keySet()) {
                System.out.println(i + " " + drinks.get(i) + " Eur");
            }

            selectDrink = input.nextLine();

            while (!drinks.containsKey(selectDrink)) {
                System.out.println("Nope... we don't have this drink: >> " + selectDrink + " << ");
               // System.out.println(drinks.keySet());
                //System.out.println(drinks.containsKey(selectDrink));
                System.out.println("Please select your drink:");
                selectDrink = input.nextLine();
            }

            if (selectDrink.equals("Tea")) {

                System.out.println("Our tea selection: ");

                for (String str : tea) {
                        System.out.print(str);
                   if(count != tea.size()-1 ) {
                       System.out.print(" | ");
                      // System.out.println(tea.size());
                       count++;
                   }

                }
                System.out.println("\nPlease choose your tea:");
                typeOfTea = input.nextLine();
                System.out.println("You selected:\t" + typeOfTea.toLowerCase() + " tea");
            }

            drinkCost = drinks.get(selectDrink);
            System.out.println("Your drink cost: " + drinkCost + " Eur");
            System.out.println("Please insert coin:");
            totalOfCoins = input2.nextDouble();
            while (totalOfCoins < drinkCost) {
                System.out.println("Remaining amount " + String.format("%.2f", (drinkCost - totalOfCoins)) + " Eur");
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