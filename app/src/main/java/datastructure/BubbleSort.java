package datastructure;

public class BubbleSort {

    public int[] bubbleSort(int[] arr) {
        int arrLenght = arr.length;
        for (int i = 0; i < arrLenght; i++) {
            for (int j = 0; j < arrLenght - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

}
