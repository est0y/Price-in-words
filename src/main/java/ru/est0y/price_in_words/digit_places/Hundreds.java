package ru.est0y.price_in_words.digit_places;

import ru.est0y.price_in_words.digit_places.api.DigitPlace;
import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;

import java.util.Map;

public class Hundreds extends DigitPlace {

    private final Map<Long, String> WORDS = Map.of(
            100L, "сто",
            200L, "двести",
            300L, "триста",
            400L, "четыреста",
            500L, "пятьсот",
            600L, "шестьсот",
            700L, "семьсот",
            800L, "восемьсот",
            900L, "девятьсот"
    );

    public Hundreds(DigitPlaceBehavior value, DigitPlaceBehavior previous) {
        super(value,previous,100,9);
    }

    @Override
    public String inWordsInternal() {
        return WORDS.get(value.getNumber()*BASE).concat(" ").concat(previous.inWords());
    }

}
