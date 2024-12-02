package D15DynamicProgramming;

public class Knapsack01 {

    // Recursive Approach
    public static int knapsackRecursive(int val[], int wt[], int w, int n) {
        if (w == 0 || n == 0) return 0; // Base case
        if (wt[n - 1] <= w) { // Current item can be included
            // Include the item
            int include = val[n - 1] + knapsackRecursive(val, wt, w - wt[n - 1], n - 1);
            // Exclude the item
            int exclude = knapsackRecursive(val, wt, w, n - 1);

            return Math.max(include, exclude);
        } else { // Current item cannot be included
            return knapsackRecursive(val, wt, w, n - 1);
        }
    }

    // Memoization (Top-Down)
    public static int knapsackMemoization(int val[], int wt[], int w, int n, int dp[][]) {
        if (w == 0 || n == 0) return 0; // Base case
        if (dp[n][w] != -1) return dp[n][w]; // Check if already computed

        if (wt[n - 1] <= w) {
            // Include the item
            int include = val[n - 1] + knapsackMemoization(val, wt, w - wt[n - 1], n - 1, dp);
            // Exclude the item
            int exclude = knapsackMemoization(val, wt, w, n - 1, dp);
            dp[n][w] = Math.max(include, exclude);
        } else {
            dp[n][w] = knapsackMemoization(val, wt, w, n - 1, dp);
        }
        return dp[n][w];
    }

    // Tabulation (Bottom-Up)
    public static int knapsackTabulation(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {
                    // Include or exclude the item
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j]; // Exclude the item
                }
            }
        }


        for (int i = 0; i <= n; i++) {
            for(int j=0;j<=W;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int w = 7;

        // Memoization DP Table Initialization
        int dp[][] = new int[val.length + 1][w + 1];
        for (int i = 0; i <= val.length; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = -1;
            }
        }

        // Outputs
        System.out.println("Maximum value (Recursive): " + knapsackRecursive(val, wt, w, val.length));
        System.out.println("Maximum value (Memoization): " + knapsackMemoization(val, wt, w, val.length, dp));
        System.out.println("Maximum value (Tabulation): " + knapsackTabulation(val, wt, w));
    }
}
