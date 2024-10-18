package D4Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int []arr, int l, int m, int r){
        int l1 = m-l+1;
        int l2 = r-m;

        int []temp1 = new int[l1];
        int []temp2 = new int[l2];

        for(int i = 0; i < temp1.length; i++){
            temp1[i] = arr[l+i];
        }
        for(int j = 0; j < temp2.length; j++){
            temp2[j] = arr[m+1+j];
        }

        int i = 0; int j = 0;
        int k = l;

        while (i < l1 && j < l2){
            if(temp1[i] <= temp2[j]){
                arr[k] = temp1[i];
                i++;
            }
            else {
                arr[k] = temp2[j];
                j++;
            }
            k++;
        }
        while (i < l1){
            arr[k++] = temp1[i++];
        }
        while (j < l2){
            arr[k++] = temp2[j++];
        }
    }

    public  static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int mid = l + (r-l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr,l, mid, r);
        }
    }

    public static void main(String[] args) {
        int []arr = {3, 60, 35,2, 45, 320, 5 };

        System.out.println("Before Sorting " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println("After Sorting " + Arrays.toString(arr));
    }
}
