package pl.krman.restaurant.drink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DrinkMenu {
    private int selectedDrink;
    private DrinkList drinkList;

    @Autowired
    public DrinkMenu(DrinkList drinkList) {
        this.drinkList = drinkList;
    }

    public DrinkMenu() {
    }

    public int showMenu() {
        System.out.println("Today in our restaurant we have the following drinks");
        drinkList.getAllDrinks().stream().forEach(System.out::println);
        Scanner sr = new Scanner(System.in);
        do {
            selectedDrink = sr.nextInt();
            if (selectedDrink > drinkList.getListSize()) {
                System.out.println("There is no such option. Try again.");
            }
        }
        while (selectedDrink > drinkList.getListSize());
        return selectedDrink;
    }
    public boolean addIce() {
        Scanner sr = new Scanner(System.in);
        System.out.println("Add ice? Y/N");
        String ice = sr.next();
        if (ice.equals("Y")) {
            return true;
        }
        return false;
    }

    public boolean addLemon(){
        Scanner sr = new Scanner(System.in);
        System.out.println("Add lemon? Y/N");
        String lemon = sr.next();
        if (lemon.equals("Y")) {
            return true;
        }
        return false;
    }
    public void orderedDrink(int selectedDrink, boolean ice, boolean lemon){

        System.out.print(drinkList.get(selectedDrink - 1).getName());
        if(ice){
            System.out.print(" with ice");
        }
        if (lemon){
            System.out.print(" with lemon");
        }
        System.out.println(" of " + drinkList.get(selectedDrink-1).getCost() + " ZŁ");
    }
}

