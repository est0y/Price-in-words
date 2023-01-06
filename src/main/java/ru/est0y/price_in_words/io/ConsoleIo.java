package ru.est0y.price_in_words.io;

import ru.est0y.price_in_words.io.api.Io;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIo implements Io {
    private final PrintStream out;
    private final Scanner in;

    public ConsoleIo(InputStream inputStream) {
        this.out = System.out;
        this.in = new Scanner(inputStream);
    }

    public long readNumber() {
        if (!in.hasNextLong()) {
            in.skip(".*\n");
            throw new InputMismatchException();
        }
        return in.nextLong();
    }

    public void output(String s) {
        out.println(s);
    }
}
