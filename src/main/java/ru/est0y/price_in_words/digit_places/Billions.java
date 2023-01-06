package ru.est0y.price_in_words.digit_places;

import ru.est0y.price_in_words.digit_places.api.DigitPlace;
import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;

public class Billions extends DigitPlace {
   public Billions(DigitPlaceBehavior value, DigitPlaceBehavior previous) {
        super(value, previous, 1_000_000_000, 999);
    }

    @Override
    public String inWords() {
        long lastValueNumber = value.getLastDigitPlace().getNumber();
        String result = value.inWords();
        if (lastValueNumber == 1) {
            result+=" миллиард";
        } else if (lastValueNumber > 1 && lastValueNumber < 5) {
            result+=" миллиарда";
        }
        else {
            result+=" миллиардов";
        }
        return result.concat(" ").concat(previous.inWords());
    }
}