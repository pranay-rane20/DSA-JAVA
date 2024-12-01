package D15DynamicProgramming;
//This que can also be done by sorting the array and finding the
//longest common subsequence

import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubsequence {


    public static int lcs(int arr1[],int arr2[]){  //0(n*m)
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2); // Take the maximum of both cases
                }
            }
        }
        return dp[n][m];
    }
    public static int lis(int arr1[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i:arr1) set.add(i);
        int arr2[] = new int[set.size()];
        int k=0;
        for(int i:set) arr2[k++] = i;
        Arrays.sort(arr2);//ascending
        return lcs(arr1,arr2);
    }
    public static void main(String[] args) {
        int arr[] = {50,3,10,7,40,80};
        int l = 4;
    }
}
