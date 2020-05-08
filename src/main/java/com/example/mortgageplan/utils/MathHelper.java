package com.example.mortgageplan.utils;

import org.springframework.stereotype.Component;

@Component("mathHelper")
public class MathHelper {
    public static float power(float base, int exponent) {
        float result = base;
        for (int i = 1; i < exponent; i++) {
            result = result * base;
        }
        return result;
    }
}
