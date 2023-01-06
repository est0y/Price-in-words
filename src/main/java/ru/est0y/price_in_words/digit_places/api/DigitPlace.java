package ru.est0y.price_in_words.digit_places.api;

public abstract class DigitPlace implements DigitPlaceBehavior {
    protected final DigitPlaceBehavior value;
    protected final DigitPlaceBehavior previous;
    protected final long BASE;

    protected DigitPlace(DigitPlaceBehavior value, DigitPlaceBehavior previous, long base, long maxValue) {
        if (value.getNumber() > maxValue || value.getNumber() < 1) {
            throw new IllegalArgumentException("expected value in range 1 to "
                    + maxValue + " but passed " + value.getNumber());
        }
        if (previous.getNumber() > base-1 || previous.getNumber() < 0) {
            throw new IllegalArgumentException("expected previous in range 0 to "
                    + (base-1) + " but passed " + previous.getNumber());
        }
        this.value = value;
        this.previous = previous;
        this.BASE = base;
    }

    @Override
    public long getNumber() {
        return value.getNumber() * BASE + previous.getNumber();
    }

    @Override
    public DigitPlaceBehavior getLastDigitPlace() {
        return previous.getLastDigitPlace();
    }

}
