package ru.est0y.price_in_words.digit_places.fakes;

import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;

import java.util.Map;

public class DPFakesMap {
    private static final Map<Integer, DigitPlaceBehavior> FAKES = Map.ofEntries(
            Map.entry(0, DigitPlaceFakeFactory.getFake(0, "", 0)),
            Map.entry(1, DigitPlaceFakeFactory.getFake(1, "один", 1)),
            Map.entry(2, DigitPlaceFakeFactory.getFake(2, "два", 2)),
            Map.entry(3, DigitPlaceFakeFactory.getFake(3, "три", 3)),
            Map.entry(9, DigitPlaceFakeFactory.getFake(9, "девять", 9)),
            Map.entry(11, DigitPlaceFakeFactory.getFake(11, "одиннадцать", 11)),
            Map.entry(31, DigitPlaceFakeFactory.getFake(31, "тридцать один", 1)),
            Map.entry(82, DigitPlaceFakeFactory.getFake(82, "восемьдесят два", 2)),
            Map.entry(99, DigitPlaceFakeFactory.getFake(99, "девяносто девять", 9)),
            Map.entry(500, DigitPlaceFakeFactory.getFake(500, "пятьсот", 0)),
            Map.entry(731, DigitPlaceFakeFactory.getFake(731, "семьсот тридцать один", 1))
    );

    public static DigitPlaceBehavior get(int key) {
        DigitPlaceBehavior dp = FAKES.get(key);
        if (dp == null) {
            throw new IllegalArgumentException("key: " + key + " is not found");
        }
        return dp;
    }
}
