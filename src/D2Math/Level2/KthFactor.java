package D2Math.Level2;


//L-1492.
//The kth Factor of n

public class KthFactor {
    public int kthFactor(int n, int k) {
        int[] arr = new int[n];
        int j=0;
        for(int i=1 ; i<=n ; i++){
            if(n%i==0) arr[j++] = i;
        }
        if(arr[k-1]!=0){
            return arr[k-1];
        }

        return -1;
    }
}
