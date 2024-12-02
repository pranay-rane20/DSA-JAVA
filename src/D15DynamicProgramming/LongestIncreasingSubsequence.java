package D15DynamicProgramming;
//This que can also be done by sorting the array and finding the
//longest common subsequence

import java.util.Arrays;
import java.util.HashSet;
public class LongestIncreasingSubsequence {

    // Function to find the Longest Common Subsequence (LCS) between two arrays
    public static int lcs(int arr1[], int arr2[]) {  // O(n * m)
        int n = arr1.length;
        int m = arr2.length;

        // DP table to store LCS values
        int[][] dp = new int[n + 1][m + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    // If elements match, increment the LCS count
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If elements don't match, take the maximum of excluding either element
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m]; // Return the length of the LCS
    }

    // Function to find the Longest Increasing Subsequence (LIS)
    public static int lis(int arr1[]) {
        // Step 1: Create a set to remove duplicates and get unique elements
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr1) {
            set.add(i);
        }

        // Step 2: Convert the set to an array
        int[] arr2 = new int[set.size()];
        int k = 0;
        for (int i : set) {
            arr2[k++] = i;
        }

        // Step 3: Sort the unique elements in ascending order
        Arrays.sort(arr2);

        // Step 4: Find the LCS between the original array and the sorted unique array
        return lcs(arr1, arr2);
    }

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};

        // Call the LIS function and print the result
        int lengthOfLIS = lis(arr);
        System.out.println("Length of Longest Increasing Subsequence: " + lengthOfLIS);
    }
}