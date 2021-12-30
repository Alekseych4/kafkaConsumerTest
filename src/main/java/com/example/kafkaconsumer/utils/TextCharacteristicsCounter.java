package com.example.kafkaconsumer.utils;

public class TextCharacteristicsCounter {

    public static int countSpaces(String text) {
        return text.replaceAll("[^ ]", "").length();
    }

    public static int countWords(String text) {
        return countSpaces(text) + 1;
    }
}
