package lesson3.second_task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Пусть дан произвольный список целых чисел, удалить из него четные числа
 */
public class SecondTask {
    public static void main(String[] args) {
        //фильтрация
        var random = new Random();
        var intStream = IntStream.generate(() -> random.nextInt(100) );
        var result = intStream.limit(20).filter(n -> n % 2 != 0).toArray();
        System.out.println(Arrays.toString(result));

        //именно удаление

        var data = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            data.add((int)(Math.random() * 100));
        }

        System.out.println("Before removing %s".formatted(data));
        data.removeIf(n -> n % 2 == 0);
        System.out.println("After removing %s".formatted(data));
    }
}
