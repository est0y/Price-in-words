package ru.est0y.price_in_words.digit_places;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.est0y.price_in_words.digit_places.fakes.DPFakesMap;

class ThousandsTest {

    @Test
    void inWords() {
        String result = new Thousands(DPFakesMap.get(1), DPFakesMap.get(111)).inWords();
        Assertions.assertEquals("одна тысяча сто одиннадцать", result);

        result = new Thousands(DPFakesMap.get(2), DPFakesMap.get(55)).inWords();
        Assertions.assertEquals("две тысячи пятьдесят пять", result);

        result = new Thousands(DPFakesMap.get(3), DPFakesMap.get(0)).inWords();
        Assertions.assertEquals("три тысячи", result);

        result = new Thousands(DPFakesMap.get(55), DPFakesMap.get(2)).inWords();
        Assertions.assertEquals("пятьдесят пять тысяч два", result);

        result = new Thousands(DPFakesMap.get(101), DPFakesMap.get(101)).inWords();
        Assertions.assertEquals("сто одна тысяча сто один", result);

        result = new Thousands(DPFakesMap.get(111), DPFakesMap.get(111)).inWords();
        Assertions.assertEquals("сто одиннадцать тысяч сто одиннадцать", result);

        result = new Thousands(DPFakesMap.get(121), DPFakesMap.get(101)).inWords();
        Assertions.assertEquals("сто двадцать одна тысяча сто один", result);

        result = new Thousands(DPFakesMap.get(202), DPFakesMap.get(101)).inWords();
        Assertions.assertEquals("двести две тысячи сто один", result);

        result = new Thousands(DPFakesMap.get(222), DPFakesMap.get(0)).inWords();
        Assertions.assertEquals("двести двадцать две тысячи", result);
    }
}