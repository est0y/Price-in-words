package ru.est0y.price_in_words.digit_places;

import ru.est0y.price_in_words.digit_places.api.DigitPlace;
import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;

public class Thousands extends DigitPlace {
    public Thousands(DigitPlaceBehavior value, DigitPlaceBehavior previous) {
        super(value, previous, 1000, 999999);
    }

    @Override
    public String inWords() {
        long lastDigitPlaceValue = value.getLastDigitPlace().getNumber();
        String result = value.inWords().trim();
        if (lastDigitPlaceValue == 0 || lastDigitPlaceValue > 4) {
            result = result.concat(" тысяч");
        } else if (lastDigitPlaceValue == 1) {
            result = outsideRulesValueInWords(1, "одна тысяча");
        } else if (lastDigitPlaceValue == 2) {
            result = outsideRulesValueInWords(2, "две тысячи");
        } else {
            result = result.concat(" тысячи");
        }
        return result.concat(" ").concat(previous.inWords());
    }

    private String outsideRulesValueInWords(int base, String wordConst) {
        String valueInWords = value.inWords();
        if (value.getNumber() == base) return wordConst;
        String[] words = valueInWords.split(" ");
        if (words.length == 2) {
            return words[0] + " " + wordConst;
        } else {
            return words[0] + " " + words[1] + " " + wordConst;
        }

    }


}
