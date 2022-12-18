package lesson3.first_task;

import java.util.Random;

/**
 * Реализовать алгоритм сортировки слиянием
 */
public class FirstTask {
    public static void main(String[] args) {
        int arrSize = 20;
        var extArray = new ExtArray(arrSize);
        var random = new Random();

        for(int i = 0; i < 20; i++) {
            extArray.insert(random.nextInt(100));
        }

        extArray.display();
        extArray.mergeSort();
        extArray.display();
    }
}
