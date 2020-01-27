package pl.krman.restaurant.dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class DessertMenu {

int selectedDessert;
DessertList dessertList;

    @Autowired
    public DessertMenu(DessertList dessertList) {
        this.dessertList = dessertList;
    }

    public int showMenu () {
        System.out.println("Today in our restaurant we have the following dessert");
        dessertList.getAllPolishDishes().stream().forEach(System.out::println);
        Scanner sr = new Scanner(System.in);
        do {
            selectedDessert = sr.nextInt();
            if (selectedDessert > dessertList.getListSize()) {
                System.out.println("There is no such option. Try again.");
            }
        }
        while (selectedDessert > dessertList.getListSize());
        return selectedDessert;
    }
    public String orderedDessert(int selectedDessert){
        return
                "You have chosen: "+ dessertList.get(selectedDessert - 1).getName() + " for " + dessertList.get(selectedDessert - 1).getCost() + " ZŁ";
    }
}
