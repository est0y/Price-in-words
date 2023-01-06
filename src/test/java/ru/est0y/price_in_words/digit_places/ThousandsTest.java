package ru.est0y.price_in_words.digit_places;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;
import ru.est0y.price_in_words.digit_places.fakes.DigitPlaceFakeFactory;

class ThousandsTest {

    @Test
    void inWords() {
        DigitPlaceBehavior value = DigitPlaceFakeFactory.getFake(1, "один", 1);
        DigitPlaceBehavior previous = DigitPlaceFakeFactory.getFake(111L, "сто одиннадцать", 11);
        String result = new Thousands(value, previous).inWords();
        Assertions.assertEquals("одна тысяча сто одиннадцать", result);

        value = DigitPlaceFakeFactory.getFake(2, "два", 2);
        previous = DigitPlaceFakeFactory.getFake(255, "двести пятдесят пять", 5);
        result = new Thousands(value, previous).inWords();
        Assertions.assertEquals("две тысячи двести пятдесят пять", result);

        result = new Thousands(previous, value).inWords();
        Assertions.assertEquals("двести пятдесят пять тысяч два", result);

        value = DigitPlaceFakeFactory.getFake(101, "сто один", 1);
        previous = DigitPlaceFakeFactory.getFake(255, "двести пятдесят пять", 5);
        result = new Thousands(value, previous).inWords();
        Assertions.assertEquals("сто одна тысяча двести пятдесят пять", result);
    }
}