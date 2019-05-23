package org.tosunsi.fizzbuzz.refacto;

public enum FizzBuzzText {

    FIZZ_BUZZ("FizzBuzz"),
    FIZZ("Fizz"),
    BUZZ("Buzz");

    private String text;

    FizzBuzzText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
