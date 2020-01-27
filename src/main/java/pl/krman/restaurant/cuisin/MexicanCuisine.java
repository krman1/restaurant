package pl.krman.restaurant.cuisin;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class MexicanCuisine {
    private final List<Dish> mexicanDishes = new ArrayList<Dish>();

    public MexicanCuisine() {
        mexicanDishes.add(new Dish(1L,"GUACAMOLE",new BigDecimal(7.00)));
        mexicanDishes.add(new Dish(2L,"BURRITO",new BigDecimal(12.00)));
        mexicanDishes.add(new Dish(3L,"CHILI CON CARNE",new BigDecimal(17.00)));
    }
    public List<Dish> getAllMexicanDishes () {
        return new ArrayList<>(mexicanDishes);
    }
    public int getListSize(){
        return mexicanDishes.size();
    }
    public Dish get(int cuisinName){
        return mexicanDishes.get(cuisinName);
    }
}
