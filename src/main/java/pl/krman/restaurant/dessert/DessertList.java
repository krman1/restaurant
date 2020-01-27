package pl.krman.restaurant.dessert;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DessertList {

    private final List<Dessert> dessers = new ArrayList<Dessert>();

    public DessertList() {
        dessers.add(new Dessert(1L,"TIRAMISU",new BigDecimal(5.00)));
        dessers.add(new Dessert(2L,"APPLE PIE",new BigDecimal(6.00)));
        dessers.add(new Dessert(3L,"CHEESECAKE",new BigDecimal(7.00)));
    }
    public List<Dessert> getAllPolishDishes () {
        return new ArrayList<>(dessers);
    }
    public int getListSize(){
        return dessers.size();
    }

    public Dessert get(int index){
        return dessers.get(index);
    }
}
