package lesson3.third_task;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
 */
public class ThirdTask {
    public static void main(String[] args) {
        var data = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++) {
            data.add((int)(Math.random() * 100));
        }

        System.out.println(data);

        //через стримы
        int min = data.stream().min(Integer::compare).get();
        int max = data.stream().max(Integer::compare).get();
        double average = data.stream().collect(Collectors.averagingInt(n -> n));

        System.out.println("Min = %d, max = %d, average = %.2f".formatted(min, max, average));

        //путём перебора
        var finalMin = new AtomicInteger(data.get(0));
        var finalMax = new AtomicInteger(0);
        var finalSum = new AtomicInteger(0);
        data.forEach(n -> {
            if (finalMin.get() > n) {
                finalMin.set(n);
            }
            if(finalMax.get() < n) {
                finalMax.set(n);
            }
            finalSum.addAndGet(n);
        });

        System.out.println("Min = %d, max = %d, average = %.2f".formatted(finalMin.get(), finalMax.get(), finalSum.get() / (float)data.size()));
    }
}
