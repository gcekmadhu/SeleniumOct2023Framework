package com.qa.opencart.utils;

public class GenerateRandomNumber {

    public static Integer generateRandomNum(){
        int min = 50; // Minimum value of range
        int max = 100; // Maximum value of range

        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;
    }
}
