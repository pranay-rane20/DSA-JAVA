package D15DynamicProgramming;

import java.util.Arrays;

// This class solves the Matrix Chain Multiplication problem using recursion.
public class MatrixChainMultiplication {

    // Recursive function to calculate the minimum cost of multiplying matrices
    public static int MCMR(int arr[], int i, int j) {
        // Base case: If there's only one matrix, no multiplication cost
        if (i == j) return 0;

        // Initialize answer to the maximum possible value
        int ans = Integer.MAX_VALUE;

        // Iterate through all possible ways to split the chain
        for (int k = i; k < j; k++) {
            // Recursive cost of multiplying the left part of the chain
            int cst1 = MCMR(arr, i, k);
            // Recursive cost of multiplying the right part of the chain
            int cst2 = MCMR(arr, k + 1, j);
            // Cost of multiplying the resulting matrices from left and right parts
            int cst3 = arr[i - 1] * arr[k] * arr[j];
            // Total cost of this particular split
            int finalcst = cst1 + cst2 + cst3;
            // Update the minimum cost
            ans = Math.min(ans, finalcst);
        }
        // Return the minimum cost found
        return ans;
    }


    // Function to calculate the Minimum Cost of Matrix Multiplication (MCMM)
    public static int MCMM(int arr[], int i, int j, int[][] dp) {
        // Base case: If there's only one matrix, no cost of multiplication
        if (i == j) return 0;

        // If the result for this subproblem is already computed, return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Initialize the minimum cost as the maximum possible value
        int ans = Integer.MAX_VALUE;

        // Try all possible positions to split the matrix chain
        for (int k = i; k <= j - 1; k++) {
            // Cost of multiplying the left part of the chain
            int cst1 = MCMM(arr, i, k, dp);
            // Cost of multiplying the right part of the chain
            int cst2 = MCMM(arr, k + 1, j, dp);
            // Cost of multiplying the resulting two matrices
            int cst3 = arr[i - 1] * arr[k] * arr[j];
            // Total cost for this partitioning
            int finalcst = cst1 + cst2 + cst3;
            // Update the minimum cost
            ans = Math.min(ans, finalcst);
        }
        // Store the result of this subproblem in the dp array for memoization
        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        // Array representing the dimensions of matrices
        // Example: For matrices A1(1x2), A2(2x3), A3(3x4), A4(4x3), arr[] = {1, 2, 3, 4, 3}
        int[] arr = {1, 2, 3, 4, 3};

        // Length of the dimensions array
        int n = arr.length;

        // Call the recursive function to compute the minimum multiplication cost
        // Multiply matrices from 1 to n-1
        int minCost = MCMR(arr, 1, n - 1);

        // Print the result
        System.out.println("Minimum cost of multiplication: " + minCost);



        int dp[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);
        }
    }
}
