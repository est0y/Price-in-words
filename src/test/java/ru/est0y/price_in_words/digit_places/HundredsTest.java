package ru.est0y.price_in_words.digit_places;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.est0y.price_in_words.digit_places.fakes.DPFakesMap;

class HundredsTest {

    @Test
    void inWords() {
        String result = new Hundreds(DPFakesMap.get(9), DPFakesMap.get(99)).inWords();
        Assertions.assertEquals("девятьсот девяносто девять", result);

        result = new Hundreds(DPFakesMap.get(9), DPFakesMap.get(0)).inWords();
        Assertions.assertEquals("девятьсот", result);

        result = new Hundreds(DPFakesMap.get(3), DPFakesMap.get(31)).inWords();
        Assertions.assertEquals("триста тридцать один", result);

    }
}