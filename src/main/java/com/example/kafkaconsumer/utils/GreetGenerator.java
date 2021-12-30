package com.example.kafkaconsumer.utils;

import java.util.Random;

public class GreetGenerator {
    private static String[] greets = {" hello ", " dear friend ", " you are welcome ", " you are the man (writer)! "};

    public static String getGreet(String name) {
        String n = " " + name + " ";
        Random random = new Random();
        StringBuilder builder = new StringBuilder("Dear, " + n + "! ");

        for (int i = 0; i < greets.length; i++) {
            int index = random.nextInt(3);
            builder.append(greets[index]);
        }

        return builder.toString();
    }
}
