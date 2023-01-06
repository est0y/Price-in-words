package ru.est0y.price_in_words.digit_places;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.est0y.price_in_words.digit_places.api.DigitPlace;
import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;
import ru.est0y.price_in_words.digit_places.fakes.DPFakesMap;

class DigitPlaceTest {
    @Test
    void ConstructorException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new DigitPlace(DPFakesMap.get(99),DPFakesMap.get(1),10,9) {
                @Override
                public String inWords() {
                    return null;
                }
            };
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new DigitPlace(DPFakesMap.get(9),DPFakesMap.get(11),10,9) {
                @Override
                public String inWords() {
                    return null;
                }
            };
        });

    }

    @Test
    void getNumber() {
            DigitPlaceBehavior dp = new DigitPlace(DPFakesMap.get(9), DPFakesMap.get(1), 10, 9) {
                @Override
                public String inWords() {
                    return null;
                }
            };
        Assertions.assertEquals(91,dp.getNumber());
        }

}