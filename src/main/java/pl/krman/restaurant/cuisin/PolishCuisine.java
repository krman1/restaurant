package pl.krman.restaurant.cuisin;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class PolishCuisine {
    private final List<Dish> polishDishes = new ArrayList<Dish>();

    public PolishCuisine() {
        polishDishes.add(new Dish(1L,"ROLLED CABAGE WITH MINCED MEAT",new BigDecimal(10.00)));
        polishDishes.add(new Dish(2L,"BREADED PORK CUTLET",new BigDecimal(15.00)));
        polishDishes.add(new Dish(3L,"BLACK PUDDING",new BigDecimal(9.00)));
    }
    public List<Dish> getAllPolishDishes () {
        return new ArrayList<>(polishDishes);
    }
    public int getListSize(){
        return polishDishes.size();
    }
    public Dish get(int cuisinName){
        return polishDishes.get(cuisinName);
    }
}
