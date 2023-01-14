package ru.est0y.price_in_words.digit_places.builders;

import ru.est0y.price_in_words.digit_places.NullDigitPlace;
import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;
import ru.est0y.price_in_words.exceptions.TooBigNumberException;

import java.util.ArrayList;
import java.util.List;

public class DigitPlaceBuilder {
    private final DigitPlaceClasses classes;
    public DigitPlaceBuilder(DigitPlaceClasses classes){
        this.classes=classes;
    }
    public DigitPlaceBehavior build(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Positive number expected but passed " + number);
        }
        try {
            return makeDigitPlace(number);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new TooBigNumberException(e);
        }
    }

    public DigitPlaceBehavior makeDigitPlace(long number) {
        List<Long> numList = listFromNumber(number);
        DigitPlaceBehavior result;
        long temp;
        if (numList.size() == 1 && numList.get(0) == 0) return classes.getInstance(0);
        if (numList.get(0) == 0) result = new NullDigitPlace();
        else {
            result = classes.getInstance(numList.get(0));
        }
        for (int i = 1, j = 1; i < numList.size(); i++, j++) {
            if (i > 2) {
                temp = numberFromList(numList, i);
                i += 2;
            } else {
                temp = numList.get(i);
            }
            if (temp == 0) {
                continue;
            }
            result = classes.getInstance(j,makeDigitPlace(temp), result);
        }
        return result;
    }


    private List<Long> listFromNumber(long number) {
        if (number == 0) return List.of(number);
        List<Long> list = new ArrayList<>();
        for (long i = number, value = i % 10; i > 0; i = i / 10, value = i % 10) {
            list.add(value);
        }
        return list;
    }

    private long numberFromList(List<Long> list, int index) {
        String str = "";
        for (int i = 0; i < 3; i++) {

            if (index >= list.size()) continue;
            str = list.get(index) + str;
            index++;
        }
        return Long.parseLong(str);
    }
}
