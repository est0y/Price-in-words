package ru.est0y.price_in_words.digit_places;

import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;

import java.util.Map;

public class Ones implements DigitPlaceBehavior {
    private final long value;
    private final Map<Integer, String> WORDS = Map.of(
            0, "ноль",
            1, "один",
            2, "два",
            3, "три",
            4, "четыре",
            5, "пять",
            6, "шесть",
            7, "семь",
            8, "восемь",
            9, "девять"
    );

    public Ones(long number) {
        this.value = number;
    }

    @Override
    public String inWords() {
        String result = this.WORDS.get((int) value);
        if (result == null) {
            throw new IllegalArgumentException("expected integer 0-9");
        }
        return result;
    }

    @Override
    public long getNumber() {
        return value;
    }

    @Override
    public DigitPlaceBehavior getLastDigitPlace() {
        return this;
    }
}
