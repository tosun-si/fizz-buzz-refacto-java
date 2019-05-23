## fizz-buzz-refacto-java

The goal of this project is propose a legacy code for the Fizz Buzz, and a refacto of this, with Java (11 in this case).

The refacto is based on FP and composition.

This refacto show how to improve the code design of the legacy and replace the multiple "if then else" by a composition class based on functions.

### The legacy code

```java
for (int i = 1; i <= 100; i++) {
    if (i % 15 == 0) {
        System.out.println("FizzBuzz");
    } else if (i % 3 == 0) {
        System.out.println("Fizz");
    } else if (i % 5 == 0) {
        System.out.println("Buzz");
    } else {
        System.out.println(i);
    }
}
```

### The refacto of code (the client of the API)
```java
final List<String> texts = IntStream.rangeClosed(1, 100)
        .mapToObj(FizzBuzzRefacto::getText)
        .collect(toList());

texts.forEach(System.out::println);

private static String getText(final Integer rowIndex) {
    return FizzBuzzTextFactory.fromRowIndex(rowIndex)
            .register(FizzBuzzRefacto::isFizzBuzzIndex, FizzBuzzText.FIZZ_BUZZ)
            .register(FizzBuzzRefacto::isFizzIndex, FizzBuzzText.FIZZ)
            .register(FizzBuzzRefacto::isBuzzIndex, FizzBuzzText.BUZZ)
            .get();
}
```
