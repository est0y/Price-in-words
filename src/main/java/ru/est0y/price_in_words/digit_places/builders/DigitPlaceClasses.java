package ru.est0y.price_in_words.digit_places.builders;

import ru.est0y.price_in_words.digit_places.api.DigitPlaceBehavior;

public interface DigitPlaceClasses {
   DigitPlaceBehavior getInstance(long number);
   DigitPlaceBehavior getInstance(int index,DigitPlaceBehavior value,DigitPlaceBehavior previous);
}
