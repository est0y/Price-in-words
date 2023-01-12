package ru.est0y.price_in_words.currency;

import ru.est0y.price_in_words.currency.api.Currency;

public class Ruble implements Currency {
    public String getWordByLastNumber(long lastNumber) {
        if (lastNumber == 1) {
            return "рубль";
        } else if (lastNumber > 1 && lastNumber < 5) {
            return "рубля";
        } else {
            return "рублей";
        }
    }

}
