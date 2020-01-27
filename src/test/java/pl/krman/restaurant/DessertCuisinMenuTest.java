package pl.krman.restaurant;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.krman.restaurant.dessert.DessertList;
import pl.krman.restaurant.dessert.DessertMenu;

class DessertCuisinMenuTest {

    @Test
    void orderedDrinkTest() {
        //Given
        DessertMenu dessertMenu = new DessertMenu(new DessertList());
        //When
        String result = dessertMenu.orderedDessert(1);
        System.out.println(result);
        //Then
        Assert.assertEquals("You have chosen: TIRAMISU for 5 ZŁ",result);

    }
}