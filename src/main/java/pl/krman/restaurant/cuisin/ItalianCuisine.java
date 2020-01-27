package pl.krman.restaurant.cuisin;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItalianCuisine {
    private final List<Dish> italianDishes = new ArrayList<Dish>();

    public ItalianCuisine() {
        italianDishes.add(new Dish(1L,"PIZZA",new BigDecimal(6.00)));
        italianDishes.add(new Dish(2L,"SPAGHETTI",new BigDecimal(17.00)));
        italianDishes.add(new Dish(3L,"RIZZOTO",new BigDecimal(19.00)));
    }
    public List<Dish> getAllItalianDishes () {
        return new ArrayList<>(italianDishes);
    }
    public int getListSize(){
        return italianDishes.size();
    }
    public Dish get(int cuisinName){
        return italianDishes.get(cuisinName);
    }
}
