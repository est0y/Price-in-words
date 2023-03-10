package ru.est0y.price_in_words;

import ru.est0y.price_in_words.currency.api.Currency;
import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;
import ru.est0y.price_in_words.digit_places.builders.DigitPlaceBuilder;
import ru.est0y.price_in_words.digit_places.builders.DPClassesList;
import ru.est0y.price_in_words.io.api.Io;

import java.util.InputMismatchException;

public class ApplicationRunner {
    final private Io io;
    final private Currency currency;

    ApplicationRunner(Io io, Currency currency) {
        this.io = io;
        this.currency = currency;
    }

    public void run() {
        long number = getNumber();
        DigitPlaceBehavior digitPlace = new DigitPlaceBuilder(new DPClassesList()).build(number);
        long lastNumber = digitPlace.getLastDigitPlace().getNumber();
        String currencyString = currency.getWordByLastNumber(lastNumber);
        io.output(digitPlace.inWords() + " " + currencyString);
    }

    private long getNumber() {
        io.output("Введите число:");
        try {
            return io.readNumber();
        } catch (InputMismatchException e) {
            io.output("Введено не число!");
            return getNumber();
        }
    }
}
