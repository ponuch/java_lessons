package lesson3.second_task;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Пусть дан произвольный список целых чисел, удалить из него четные числа
 */
public class SecondTask {
    public static void main(String[] args) {
        var random = new Random();
        var intStream = IntStream.generate(() -> random.nextInt(100) );
        var result = intStream.limit(20).filter(n -> n % 2 != 0).toArray();
        System.out.println(Arrays.toString(result));
    }
}
