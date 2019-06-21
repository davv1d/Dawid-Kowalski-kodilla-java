package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .burgers(5)
                .sauce("BBQ")
                .ingredient("Onion")
                .ingredient("Cheese")
                .ingredient("Chili")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        String standardBun = bigmac.getBun();
        //Then
        Assert.assertEquals(3, howManyIngredients);
        Assert.assertEquals("standard", standardBun);
    }
}
