package pl.krman.restaurant.cuisin;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CuisinsList {

    private final List<Cuisin> cuisins = new ArrayList<Cuisin>();

    public CuisinsList() {
        cuisins.add(new Cuisin(1L,"Polish cuisine"));
        cuisins.add(new Cuisin (2L,"Mexican cuisine"));
        cuisins.add(new Cuisin (3L,"Italian cuisine"));
    }

    public List<Cuisin> getAllCuisins () {
        return new ArrayList<>(cuisins);
    }

    public int getListSize(){
        return cuisins.size();
    }

}
