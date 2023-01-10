package lesson5.third_task;

import java.util.Arrays;

/**
 * Реализовать алгоритм пирамидальной сортировки (HeapSort).
 */
public class Heap {
    public static void main(String[] args) {
        int[] array = { 455, 142, 9, 75, 84, 34, 75 };
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void heapSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        int length = array.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;
            heapify(array, length, largest);
        }
    }
}
