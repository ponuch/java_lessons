package lesson3.first_task;

import java.util.Arrays;

public class ExtArray {
    private int[] internalArray;
    private int elemCount;

    public ExtArray(int elemCount) {
        this.internalArray = new int[elemCount];
        this.elemCount = 0;
    }

    /**
     * Вставка нового элемента в массив
     * @param newValue - элемент для вставки
     */
    public void insert(int newValue) {
        internalArray[elemCount] = newValue;
        elemCount++;
    }

    /**
     * Показ массива
     */
    public void display() {
        System.out.println(Arrays.toString(internalArray));
    }

    public void mergeSort() {
        int[] workSpace = new int[elemCount];
        recursiveMergeSort(workSpace, 0, elemCount - 1);
    }

    private void recursiveMergeSort(int[] workSpace, int lowerBound, int upperBound) {
        if(lowerBound == upperBound) {
            return;
        }
        else {
            int middle = (lowerBound + upperBound) / 2;
            //сортировка нижней половины
            recursiveMergeSort(workSpace, lowerBound, middle);
            //сортировка верхней половины
            recursiveMergeSort(workSpace, middle + 1, upperBound);
            //слияние
            merge(workSpace, lowerBound, middle + 1, upperBound);
        }
    }

    private void merge(int[] workSpace, int lowPrt, int highPtr, int upperBound) {
        int i = 0;
        int lowerBound = lowPrt;
        int middle = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        while(lowPrt <= middle && highPtr <= upperBound) {
            if (internalArray[lowPrt] < internalArray[highPtr]){
                workSpace[i++] = internalArray[lowPrt++];
            }
            else {
                workSpace[i++] = internalArray[highPtr++];
            }
        }

        while(lowPrt <= middle) {
            workSpace[i++] = internalArray[lowPrt++];
        }

        while (highPtr <= upperBound) {
            workSpace[i++] = internalArray[highPtr++];
        }

        for(i = 0; i < n; i++) {
            internalArray[lowerBound + i] = workSpace[i];
        }
    }
}
