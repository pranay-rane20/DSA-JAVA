package D4Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int []arr = {3, 60, 35,2, 45, 320, 5 };

        for(int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i-1;

            while (j >= 0 && arr[j] > current){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
        System.out.println(Arrays.toString(arr));
    }
}
