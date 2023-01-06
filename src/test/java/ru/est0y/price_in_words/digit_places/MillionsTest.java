package ru.est0y.price_in_words.digit_places;

import org.junit.jupiter.api.Test;
import ru.est0y.price_in_words.digit_places.fakes.DPFakesMap;

import static org.junit.jupiter.api.Assertions.*;

class MillionsTest {

    @Test
    void inWords() {
        String result=new Millions(DPFakesMap.get(9),DPFakesMap.get(9)).inWords();
        assertEquals("девять миллионов девять",result);

        result=new Millions(DPFakesMap.get(731),DPFakesMap.get(82)).inWords();
        assertEquals("семьсот тридцать один миллион восемьдесят два",result);

    }
}