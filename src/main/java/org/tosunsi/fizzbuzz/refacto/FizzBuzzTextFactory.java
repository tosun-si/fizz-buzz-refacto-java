package org.tosunsi.fizzbuzz.refacto;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import static java.lang.String.valueOf;

/**
 * This class allows, via cases to build the good fizz buzz text, by the given row index.
 */
public class FizzBuzzTextFactory {

    private final int rowIndex;
    private final Map<Boolean, String> cases;

    private FizzBuzzTextFactory(final int rowIndex) {
        cases = new HashMap<>();
        this.rowIndex = rowIndex;
    }

    public static FizzBuzzTextFactory fromRowIndex(final int rowIndex) {
        return new FizzBuzzTextFactory(rowIndex);
    }

    public FizzBuzzTextFactory register(final Predicate<Integer> filterOnIndex, final FizzBuzzText textEnum) {
        cases.putIfAbsent(filterOnIndex.test(rowIndex), textEnum.getText());

        return this;
    }

    public String get() {
        return cases.getOrDefault(true, valueOf(rowIndex));
    }
}
