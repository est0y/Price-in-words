package ru.est0y.price_in_words;

import ru.est0y.price_in_words.currency.Ruble;
import ru.est0y.price_in_words.currency.api.Currency;
import ru.est0y.price_in_words.io.ConsoleIo;
import ru.est0y.price_in_words.io.api.Io;

public class App {
    public static void main(String[] args) {
        Currency currency = new Ruble();
        Io io = new ConsoleIo(System.in);
        new ApplicationRunner(io, currency).run();
    }

}
