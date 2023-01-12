package ru.est0y.price_in_words.digit_places;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.est0y.price_in_words.digit_places.Ones;

import static org.junit.jupiter.api.Assertions.*;

class OnesTest {

    @Test
    void inWords() {
        String result=new Ones(5).inWords();
        Assertions.assertEquals("пять",result);
        result=new Ones(8).inWords();
        Assertions.assertEquals("восемь",result);
    }
    @Test
    void inWordsException(){
             assertThrows(IllegalArgumentException.class, () -> {
                String result=new Ones(500).inWords();
            });
    }
}