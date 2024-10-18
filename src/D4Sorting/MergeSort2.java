package D4Sorting;

import java.util.Arrays;

public class MergeSort2 {

    public static void divide(int arr[], int l, int r){
        if(l >= r)return;
        int mid = (l+r)/2;
        divide(arr, l, mid);
        divide(arr, mid+1, r);
        conquer(arr, l, mid, r);
    }

    public static void conquer(int arr[], int l, int mid, int r){
        int temp[] = new int[r-l+1];
        int idx1 = l;
        int idx2 = mid+1;
        int x = 0;
        while (idx1 <= mid && idx2 <= r){
            if(arr[idx1] <= arr[idx2])temp[x++] = arr[idx1++];
            else temp[x++] = arr[idx2++];
        }
        while (idx1 <= mid){
            temp[x++] = arr[idx1++];
        }
        while (idx2 <= r){
            temp[x++] = arr[idx2++];
        }
        for(int i = l, k = 0; k < temp.length; i++, k++){
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[] = {21,65,42,12,56,59,89,27};
        divide(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
