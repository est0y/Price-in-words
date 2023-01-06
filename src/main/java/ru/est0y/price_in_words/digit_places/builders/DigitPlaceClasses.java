package ru.est0y.price_in_words.digit_places.builders;

import ru.est0y.price_in_words.digit_places.Hundreds;
import ru.est0y.price_in_words.digit_places.Ones;
import ru.est0y.price_in_words.digit_places.Tens;
import ru.est0y.price_in_words.digit_places.Thousands;
import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;
import ru.est0y.price_in_words.exceptions.NoSuchDeclaredConstructorException;

import java.lang.reflect.InvocationTargetException;

enum DigitPlaceClasses {
    ONES(Ones.class) {
        public DigitPlaceBehavior getDigitPlaceInstance(long number) {
            return new Ones(number);
        }
    },
    TENS(Tens.class),
    HUNDREDS(Hundreds.class),
    THOUSAND(Thousands.class),
    Millions(ru.est0y.price_in_words.digit_places.Millions.class),
    Billions(ru.est0y.price_in_words.digit_places.Billions.class);
    private final Class<DigitPlaceBehavior> digitPlace;

    DigitPlaceClasses(Class digitPlace) {
        this.digitPlace = digitPlace;
    }


    public DigitPlaceBehavior getDigitPlaceInstance(long number) {
        throw new IllegalCallerException("Cannot created instance of " + this.digitPlace.getName() +
                " with long type parameter.");
    }

    public DigitPlaceBehavior getDigitPlaceInstance(DigitPlaceBehavior dp, DigitPlaceBehavior previous) {
        try {
            Class[] classes = {DigitPlaceBehavior.class, DigitPlaceBehavior.class};
            return digitPlace.getDeclaredConstructor(classes)
                    .newInstance(dp, previous);
        } catch (NoSuchMethodException e) {
            throw new NoSuchDeclaredConstructorException("Нету объявленного конструктора в " + digitPlace,
                    e);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}