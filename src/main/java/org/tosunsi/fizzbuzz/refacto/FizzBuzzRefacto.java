package org.tosunsi.fizzbuzz.refacto;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class FizzBuzzRefacto {

    public static void main(String[] args) {
        final List<String> texts = IntStream.rangeClosed(1, 100)
                .mapToObj(FizzBuzzRefacto::getText)
                .collect(toList());

        texts.forEach(System.out::println);
    }

    private static String getText(final Integer rowIndex) {
        return FizzBuzzTextFactory.fromRowIndex(rowIndex)
                .register(FizzBuzzRefacto::isFizzBuzzIndex, FizzBuzzText.FIZZ_BUZZ)
                .register(FizzBuzzRefacto::isFizzIndex, FizzBuzzText.FIZZ)
                .register(FizzBuzzRefacto::isBuzzIndex, FizzBuzzText.BUZZ)
                .get();
    }

    private static boolean isFizzBuzzIndex(final Integer rowIndex) {
        return rowIndex % 15 == 0;
    }

    private static boolean isFizzIndex(final Integer rowIndex) {
        return rowIndex % 3 == 0;
    }

    private static boolean isBuzzIndex(final Integer rowIndex) {
        return rowIndex % 5 == 0;
    }
}
