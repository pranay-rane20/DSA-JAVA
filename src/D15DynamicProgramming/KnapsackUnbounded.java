package D15DynamicProgramming;

import java.util.Arrays;

public class KnapsackUnbounded {

    // Memoization (Top-Down)
    public static int unboundedKnapsackMemoization(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n][W + 1];

        // Initialize memoization table with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solveKnapsack(val, wt, n - 1, W, dp);
    }

    private static int solveKnapsack(int[] val, int[] wt, int i, int W, int[][] dp) {
        // Base cases
        if (i < 0 || W == 0) {
            return 0;
        }

        // If already computed, return the stored result
        if (dp[i][W] != -1) {
            return dp[i][W];
        }

        // If the weight of the current item exceeds the capacity, exclude it
        if (wt[i] > W) {
            return dp[i][W] = solveKnapsack(val, wt, i - 1, W, dp);
        }

        // Include the item (recur for the same item as it is unbounded) or exclude it
        int includeItem = val[i] + solveKnapsack(val, wt, i, W - wt[i], dp);
        int excludeItem = solveKnapsack(val, wt, i - 1, W, dp);

        // Store and return the maximum profit
        return dp[i][W] = Math.max(includeItem, excludeItem);
    }

    // Tabulation (Bottom-Up)
    public static int unboundedKnapsackTabulation(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    // Include current item or exclude it
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    // Exclude current item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    // Main function
    public static void main(String[] args) {
        int W = 8; // Knapsack capacity
        int[] wt = {1, 3, 4, 5}; // Weights of items
        int[] val = {10, 40, 50, 70}; // Values of items

        // Solve using Memoization
        int maxValueMemoization = unboundedKnapsackMemoization(val, wt, W);
        System.out.println("Maximum value (Memoization): " + maxValueMemoization);

        // Solve using Tabulation
        int maxValueTabulation = unboundedKnapsackTabulation(val, wt, W);
        System.out.println("Maximum value (Tabulation): " + maxValueTabulation);
    }
}
