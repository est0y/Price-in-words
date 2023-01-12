package ru.est0y.price_in_words.digit_places;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.est0y.price_in_words.digit_places.fakes.DPFakesMap;

class TensTest {

    @Test
    void inWords() {
        String result=new Tens(DPFakesMap.get(9),DPFakesMap.get(0)).inWords();
        Assertions.assertEquals("девяносто",result);

        result=new Tens(DPFakesMap.get(3),DPFakesMap.get(1)).inWords();
        Assertions.assertEquals("тридцать один",result);

        result=new Tens(DPFakesMap.get(1),DPFakesMap.get(1)).inWords();
        Assertions.assertEquals("одиннадцать",result);
    }
}