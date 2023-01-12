package ru.est0y.price_in_words.digit_places.fakes;

import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;

public class DigitPlaceFakeFactory {
    public static DigitPlaceBehavior getFake(long number,String text,long lastDigitPlaceValue){
        return new DigitPlaceBehavior() {
            @Override
            public String inWords() {
                return text;
            }

            @Override
            public long getNumber() {
                return number;
            }

            @Override
            public DigitPlaceBehavior getLastDigitPlace() {
                return new DigitPlaceBehavior() {
                    @Override
                    public String inWords() {
                        return null;
                    }

                    @Override
                    public long getNumber() {
                        return lastDigitPlaceValue;
                    }

                    @Override
                    public DigitPlaceBehavior getLastDigitPlace() {
                        return null;
                    }
                };
            }
        };
    }
}
