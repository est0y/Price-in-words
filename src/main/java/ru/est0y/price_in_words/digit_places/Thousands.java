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
        if (lastDigitPlaceValue % 10 == 0 ||
                (lastDigitPlaceValue > 10 && lastDigitPlaceValue < 20)
                || (lastDigitPlaceValue > 4 && lastDigitPlaceValue < 10)) {
            result = result.concat(" тысяч");
        } else if (lastDigitPlaceValue == 1) {
            if (value.getNumber() == 1) result = "одна тысяча";
            else {
                String[] dp = result.split(" ");
                result = dp[0] + " одна тысяча";
            }
        } else if (lastDigitPlaceValue == 2) {
            if (value.getNumber() == 2) {
                result = "две тысячи";
            } else {
                String[] dp = result.split(" ");
                result = dp[0] + " " + dp[1] + " две тысячи";
            }
        } else {
            result = result.concat(" тысячи");
        }
        return result.concat(" ").concat(previous.inWords());
    }


}
