package ru.est0y.price_in_words.digit_places.api;

public interface DigitPlaceBehavior {
    String inWords();

    long getNumber();

    DigitPlaceBehavior getLastDigitPlace();
}

