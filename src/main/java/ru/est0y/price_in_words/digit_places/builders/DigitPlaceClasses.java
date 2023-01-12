package ru.est0y.price_in_words.digit_places.builders;

import ru.est0y.price_in_words.digit_places.*;
import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;
import ru.est0y.price_in_words.exceptions.NoSuchDeclaredConstructorException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class DigitPlaceClasses {
    private final static List<Class<? extends DigitPlaceBehavior>> list = List.of(
            Ones.class,
            Tens.class,
            Hundreds.class,
            Thousands.class,
            Millions.class,
            Billions.class
    );

    public DigitPlaceBehavior getInstance(int index, long number) {
        return new Ones(number);
    }

    public DigitPlaceBehavior getInstance(int index, DigitPlaceBehavior dp, DigitPlaceBehavior previous) {
        try {
            return list.get(index).getDeclaredConstructor(
                    new Class[]{DigitPlaceBehavior.class,
                            DigitPlaceBehavior.class}
            ).newInstance(dp, previous);
        } catch (NoSuchMethodException e) {
            throw new NoSuchDeclaredConstructorException("Нету объявленного конструктора в " + list.get(index),
                    e);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
