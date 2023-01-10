package ru.est0y.price_in_words.digit_places;

import ru.est0y.price_in_words.digit_places.api.DigitPlace;
import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;

import java.util.Map;

public class Tens extends DigitPlace {
    private final static Map<Long, String> WORDS = Map.of(
            10L, "десять",
            20L, "двадцать",
            30L, "тридцать",
            40L, "сорок",
            50L, "пятьдесят",
            60L, "шестьдесят",
            70L, "семьдесят",
            80L, "восемьдесят",
            90L, "девяносто"
    );
    private final static Map<Integer, String> outsideRules = Map.of(
            10, "десять",
            11, "одиннадцать",
            12, "двенадцать",
            13, "тринадцать",
            14, "четырнадцать",
            15, "пятнадцать",
            16, "шестнадцать",
            17, "семнадцать",
            18, "восемьнадцать",
            19, "девятнадцать"
    );

    public Tens(DigitPlaceBehavior value, DigitPlaceBehavior previous) {
        super(value, previous, 10,9);
    }

    @Override
    public String inWordsInternal() {
        if (value.getNumber() == 1) {
            return outsideRules.get((int) (this.getNumber()));
        }
        return WORDS.get(value.getNumber() * BASE).concat(" ").concat(previous.inWords());
    }

    @Override
    public DigitPlaceBehavior getLastDigitPlace() {
        if (this.getNumber() > 10 && this.getNumber() < 20) return this;
        return super.getLastDigitPlace();
    }

}
