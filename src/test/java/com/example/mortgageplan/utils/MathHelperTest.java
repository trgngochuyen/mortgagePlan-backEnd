package com.example.mortgageplan.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathHelperTest {
    MathHelper mathHelper = new MathHelper();

    // 2,2 => 4
    @Test
    public void power_a_positive_number() {
        System.out.println("Power a positive number");
        assertEquals(4, mathHelper.power(2, 2));
    }

    // -3, 2 => 9
    @Test
    public void power_a_negative_number() {
        System.out.println("Power a negative number");
        assertEquals(9, mathHelper.power(-3, 2));
    }

    // 0, 5 => 0
    @Test
    public void power_zero() {
        System.out.println("Power zero");
        assertEquals(0, mathHelper.power(0, 5));
    }

    // 4.24, 6 => 5810.25244140625
    @Test
    public void power_float() {
        System.out.println("Power float");
        assertEquals(5810.25244140625, mathHelper.power((float)4.24, 6));
    }

}
