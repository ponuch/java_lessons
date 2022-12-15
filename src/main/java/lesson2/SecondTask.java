package lesson2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;

/**
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */
public class SecondTask {
    private static final Logger logger = LoggerFactory.getLogger(SecondTask.class);
    public static void main(String[] args) {
        // подготавливаем данные
        int[] array = new int[20];
        var random = new Random();
        for(int i = 0; i < 20; i++){
            array[i] = random.nextInt(20);
        }
        System.out.println(Arrays.toString(array));

        for(int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    logger.info(Arrays.toString(array));
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
