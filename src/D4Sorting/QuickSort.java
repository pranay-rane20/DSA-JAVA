package D4Sorting;

import java.util.Arrays;

public class QuickSort {

    static void quickSort(int arr[], int l, int r){
        if(l >= r)return;
        int pInd = partition(arr,l,r);
        quickSort(arr,l,pInd-1);
        quickSort(arr,pInd+1, r);
    }

    static int partition(int arr[], int l, int r){
        int i = l-1;
        int pivot = arr[r];
        for(int j = l; j < r; j++){
            if(pivot > arr[j]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }

    public static void main(String[] args) {
        int arr[] = {5,1,9,6,3,2};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
