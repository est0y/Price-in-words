package ru.est0y.price_in_words.digit_places;

import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;

public class NullDigitPlace implements DigitPlaceBehavior {
    @Override
    public String inWords() {
        return "";
    }

    @Override
    public long getNumber() {
        return 0L;
    }

    @Override
    public DigitPlaceBehavior getLastDigitPlace() {
        return this;
    }
}
