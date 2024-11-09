package D13BinaryHeap;

public class HEAPSORT {
    public static void heapify(int arr[] ,int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxidx = i;
        if(left < size && arr[left] > arr[maxidx]){
            maxidx = left;
        }
        if(right < size && arr[right] > arr[maxidx]){
            maxidx = right;
        }
        if(maxidx !=i){
            int temp = arr[i];
            arr[i] = arr[maxidx];
            arr[maxidx] = temp;
            heapify(arr, maxidx, size);  //recursive call to heapify the affected sub-tree  // heapify the root node
        }

    }
    public static void heapsort(int arr[]){
        //step1- build maxheap
        int n = arr.length;
        for(int i=n/2-1; i>=0; i--){
            heapify(arr, i,n);
        }
        //step2- push largest at end
        for(int i=n-1; i>=0; i--){
            //swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //heapify root
            heapify(arr,0,i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        heapsort(arr);
        System.out.println("Sorted array is");
        for(int i: arr)
            System.out.print(i+" ");
    }
}
