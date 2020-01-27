package pl.krman.restaurant;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.krman.restaurant.cuisin.CuisinsList;

class CuisinsListTest {

    @Test
    void getListSizeTest() {
        //Given
        CuisinsList cuisinsList = new CuisinsList();
        //When
        int result = cuisinsList.getListSize();
        //Then
        Assert.assertEquals(3,result);

    }
}