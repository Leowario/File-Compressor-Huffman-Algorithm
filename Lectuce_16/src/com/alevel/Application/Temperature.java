package com.alevel.Application;

public class Temperature {
    public static boolean isValid(String temperature) {
        try {
            double value = Double.parseDouble(temperature);
            if (value < -273.15) {
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println(temperature);
            return false;
        }
        return true;
    }
}
