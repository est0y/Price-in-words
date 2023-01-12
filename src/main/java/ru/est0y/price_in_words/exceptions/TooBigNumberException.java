package ru.est0y.price_in_words.exceptions;

public class TooBigNumberException extends RuntimeException{
   public TooBigNumberException(Throwable e){
        super("Don't supported so big number",e);
    }
}
