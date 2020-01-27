package pl.krman.restaurant.contllorer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RestController;
import pl.krman.restaurant.cuisin.CuisinMenu;
import pl.krman.restaurant.cuisin.Dish;
import pl.krman.restaurant.dessert.DessertList;
import pl.krman.restaurant.dessert.DessertMenu;
import pl.krman.restaurant.drink.DrinkList;
import pl.krman.restaurant.drink.DrinkMenu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
public class RestaurantContllorer {

    private CuisinMenu cuisinMenu;
    private DrinkMenu drinkMenu;
    private DessertMenu dessertMenu;
    private DrinkList drinkList;
    private DessertList dessertList;
    int lunchOrDrink;
    String exit;
    private BigDecimal sum = new BigDecimal(0);
    private List<Dish> orderedDish = new ArrayList<Dish>();

    @Autowired
    public RestaurantContllorer(CuisinMenu cuisinMenu, DrinkMenu drinkMenu, DessertMenu dessertMenu, DrinkList drinkList, DessertList dessertList) {
        this.cuisinMenu = cuisinMenu;
        this.drinkMenu = drinkMenu;
        this.dessertMenu = dessertMenu;
        this.drinkList = drinkList;
        this.dessertList = dessertList;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start () {
        System.out.println("=================================================================================================================");
        System.out.println("Welcome to the food ordering application");
        System.out.println("=================================================================================================================");
        System.out.println();
        System.out.println("You can order lunch and a drink or just a drink ");
        System.out.println("What do you fancy today?");
        System.out.println("1 - Just a drink");
        System.out.println("2 - Lunch & drink");
        Scanner sc = new Scanner(System.in);
        do {
            lunchOrDrink = sc.nextInt();
            if (lunchOrDrink > 2) {
                System.out.println("There is no such option. Try again.");
            }
        }
        while (lunchOrDrink > 2);

        if (lunchOrDrink == 1) {
            int selectedDrink = drinkMenu.showMenu();
            boolean ice = drinkMenu.addIce();
            boolean lemon = drinkMenu.addLemon();
            System.out.print("You have chosen: ");
            drinkMenu.orderedDrink(selectedDrink, ice, lemon);
        } else {
            int cuisinName = cuisinMenu.showMenu();
            List<Dish> orderedDish = cuisinMenu.getDish(cuisinName);
            orderedDish.stream().forEach(System.out::println);
            int size = orderedDish.size();
            int dishName = cuisinMenu.getNumberDish(size);
            System.out.println("You have chosen: " + orderedDish.get(dishName - 1).getName() + " for " + orderedDish.get(dishName - 1).getCost() + " ZŁ");
            System.out.println("Now choose dessert");
            int selectedDessert = dessertMenu.showMenu();
            System.out.println(dessertMenu.orderedDessert(selectedDessert));
            System.out.println("And finally a drink");
            int selectedDrink = drinkMenu.showMenu();
            boolean ice = drinkMenu.addIce();
            boolean lemon = drinkMenu.addLemon();
            drinkMenu.orderedDrink(selectedDrink, ice, lemon);
            System.out.println("You ordered:");
            System.out.println(orderedDish.get(dishName - 1).getName() + " for " + orderedDish.get(dishName - 1).getCost() + " ZŁ");
            System.out.println(dessertList.get(selectedDessert - 1).getName() + " for " + dessertList.get(selectedDessert - 1).getCost() + " ZŁ");
            System.out.println(drinkList.get(selectedDrink - 1).getName() + " for " + drinkList.get(selectedDrink - 1).getCost() + " ZŁ");
            sum = orderedDish.get(dishName - 1).getCost().add(dessertList.get(selectedDessert - 1).getCost()).add(drinkList.get(selectedDrink - 1).getCost());
            System.out.println("To pay: " + sum + " ZŁ");
        }
        System.out.println("You confirm your order Y/N");
        Scanner sc1 = new Scanner(System.in);
        exit = sc1.next();
        if (exit.equals("N")) {
            start();
        }
        System.out.println("Thank you for using the application");
    }
}
