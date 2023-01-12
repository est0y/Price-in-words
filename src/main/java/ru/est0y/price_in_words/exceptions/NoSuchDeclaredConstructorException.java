package ru.est0y.price_in_words.exceptions;

public class NoSuchDeclaredConstructorException extends RuntimeException{
    public NoSuchDeclaredConstructorException(String message, Throwable e){
        super(message,e);
    }
}
