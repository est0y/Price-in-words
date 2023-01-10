package ru.est0y.price_in_words;

import org.junit.jupiter.api.Test;
import ru.est0y.price_in_words.digit_places.builders.DigitPlaceBuilder;

import static org.junit.jupiter.api.Assertions.*;

class DigitPlaceBuilderTest {
    String numberInWords(long number) {
        return new DigitPlaceBuilder(number).build().inWords();
    }

    @Test
    void build() {
        assertEquals("пятьдесят", numberInWords(50));

        assertEquals("сто один миллион десять тысяч сто одиннадцать",
                numberInWords(101_010_111));

        assertEquals("один миллион", numberInWords(1_000_000));

        assertEquals("один миллион сто одиннадцать тысяч сто одиннадцать",
                numberInWords(1_111_111));

        assertEquals("девятьсот девяносто девять миллионов девятьсот" +
                " девяносто девять тысяч девятьсот девяносто девять", numberInWords(999_999_999));

        assertEquals("один миллиард девятьсот девяносто девять миллионов" +
                        " девятьсот девяносто девять тысяч девятьсот девяносто девять",
                numberInWords(1_999_999_999));

        assertEquals("один миллиард", numberInWords(1_000_000_000));

        assertEquals("один миллиард один", numberInWords(1_000_000_001));

        assertEquals("один миллиард десять миллионов сто одна тысяча сто один",
                numberInWords(1_010_101_101));

        assertEquals("сто один миллиард десять миллионов сто одна тысяча десять",
                numberInWords(101_010_101_010L));

        assertEquals("девятьсот девяносто девять миллиардов девятьсот девяносто" +
                        " девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять",
                numberInWords(999_999_999_999L));
    }

    @Test
    void makeDigitPlace() {
    }
}