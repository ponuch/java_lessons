package lesson1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Вывести все простые числа от 1 до 1000
 */
public class SecondTask {
    public static void main(String[] args) {
        var list = IntStream.rangeClosed(2, 1_000)
                .filter(x -> isPrime(x)).boxed()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    private static boolean isPrime(int number) {
        //Можно воспользоваться методом из класса BigInteger.isProbablePrime
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }
}
