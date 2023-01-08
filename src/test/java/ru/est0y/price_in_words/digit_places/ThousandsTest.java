package ru.est0y.price_in_words.digit_places;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.est0y.price_in_words.digit_places.fakes.DPFakesMap;

class ThousandsTest {

    @Test
    void inWords() {
        String result = new Thousands(DPFakesMap.get(1), DPFakesMap.get(111)).inWords().trim();
        Assertions.assertEquals("одна тысяча сто одиннадцать", result);

        result = new Thousands(DPFakesMap.get(2), DPFakesMap.get(55)).inWords().trim();
        Assertions.assertEquals("две тысячи пятьдесят пять", result);

        result = new Thousands(DPFakesMap.get(3), DPFakesMap.get(0)).inWords().trim();
        Assertions.assertEquals("три тысячи", result);

        result = new Thousands(DPFakesMap.get(55), DPFakesMap.get(2)).inWords().trim();
        Assertions.assertEquals("пятьдесят пять тысяч два", result);

        result = new Thousands(DPFakesMap.get(101), DPFakesMap.get(101)).inWords().trim();
        Assertions.assertEquals("сто одна тысяча сто один", result);

        result = new Thousands(DPFakesMap.get(111), DPFakesMap.get(111)).inWords().trim();
        Assertions.assertEquals("сто одиннадцать тысяч сто одиннадцать", result);

        result = new Thousands(DPFakesMap.get(121), DPFakesMap.get(101)).inWords().trim();
        Assertions.assertEquals("сто двадцать одна тысяча сто один", result);

        result = new Thousands(DPFakesMap.get(202), DPFakesMap.get(101)).inWords().trim();
        Assertions.assertEquals("двести две тысячи сто один", result);

        result = new Thousands(DPFakesMap.get(222), DPFakesMap.get(0)).inWords().trim();
        Assertions.assertEquals("двести двадцать две тысячи", result);
    }
}