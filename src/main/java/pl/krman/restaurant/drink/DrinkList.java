package pl.krman.restaurant.drink;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DrinkList {

    public final List<Drink> drinks = new ArrayList<Drink>();

    public DrinkList() {
        drinks.add(new Drink(1L,"MOJITO",new BigDecimal(15)));
        drinks.add(new Drink(2L,"SEX ON THE BEACH",new BigDecimal(20)));
        drinks.add(new Drink(3L,"MIAMI COCKTAIL",new BigDecimal(17)));
    }
    public List<Drink> getAllDrinks (){
        return new ArrayList<>(drinks) ;
    }
    public int getListSize(){
        return drinks.size();
    }

    public Drink get(int selectedDrink) {
        return drinks.get(selectedDrink);
    }
}
