package ru.est0y.price_in_words.digit_places;

import ru.est0y.price_in_words.digit_places.api.DigitPlace;
import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;

public class Millions extends DigitPlace {
    public Millions(DigitPlaceBehavior value, DigitPlaceBehavior previous) {
        super(value, previous, 1_000_000, 999);
    }

    @Override
    public String inWordsInternal() {
        long lastValueNumber = value.getLastDigitPlace().getNumber();
        String result = value.inWords();
        if (lastValueNumber == 1) {
            result+=" миллион";
        } else if (lastValueNumber > 1 && lastValueNumber < 5) {
            result+=" миллиона";
        }
        else {
            result+=" миллионов";
        }
        return result.concat(" ").concat(previous.inWords());
    }
}