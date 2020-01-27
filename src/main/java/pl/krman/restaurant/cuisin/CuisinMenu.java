package pl.krman.restaurant.cuisin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Component
public class CuisinMenu {

    PolishCuisine polishCuisine;
    MexicanCuisine mexicanCuisine;
    ItalianCuisine italianCuisine;
    CuisinsList cuisinsList;
    public final List<Cuisin> cuisins = new ArrayList<Cuisin>();
    public List<Dish> orderedDish = new ArrayList<Dish>();
    int cuisinType;
    int dishName;

    @Autowired
    public CuisinMenu(PolishCuisine polishCuisine, MexicanCuisine mexicanCuisine, ItalianCuisine italianCuisine, CuisinsList cuisinsList) {
        this.polishCuisine = polishCuisine;
        this.mexicanCuisine = mexicanCuisine;
        this.italianCuisine = italianCuisine;
        this.cuisinsList = cuisinsList;
    }

    public int showMenu () {
        System.out.println("Today in our restaurant we have the following cuisines");
        cuisinsList.getAllCuisins().stream().forEach(System.out::println);
        Scanner sr = new Scanner(System.in);
        do {cuisinType = sr.nextInt();
            if (cuisinType > cuisinsList.getListSize()) {
                System.out.println("There is no such option. Try again.");
            }
        }
        while (cuisinType > cuisinsList.getListSize());
        return cuisinType;
    }

    public List<Dish> getDish(int cuisinType){
        if(cuisinType == 1){
            System.out.println("Today in Polish cuisine we serve the following dishes");
            orderedDish.addAll(polishCuisine.getAllPolishDishes());
        }
        if(cuisinType == 2) {
            System.out.println("Today in Mexican cuisine we serve the following dishes");
            orderedDish.addAll(mexicanCuisine.getAllMexicanDishes());
        }
        if(cuisinType == 3){
            System.out.println("Today in Italian cuisine we serve the following dishes");
            orderedDish.addAll(italianCuisine.getAllItalianDishes());
        }
        return new ArrayList<>(orderedDish);
    }

    public int getNumberDish(int size){
        Scanner sr = new Scanner(System.in);
        do {dishName = sr.nextInt();
            if (dishName > orderedDish.size()) {
                System.out.println("There is no such option. Try again.");
            }
        }
        while (dishName > orderedDish.size());
        return dishName;
    }
}
