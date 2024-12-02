package D15DynamicProgramming;

// Class to calculate the number of valid mountain and valley ranges that can be formed with `n` peaks and valleys.
// At any moment, the number of downward strokes cannot exceed the number of upward strokes.
public class MountainRanges {

    // Method to count the number of valid mountain ranges for `n` peaks and valleys.
    // This implementation uses dynamic programming and has a time complexity of O(n^2).
    public static int countMountainRanges(int n) {
        // DP array to store the number of valid mountain ranges for each number of strokes.
        int dp[] = new int[n + 1];

        // Base cases:
        // dp[0] = 1: There's exactly one valid way to form a range with 0 peaks (an empty range).
        // dp[n] = 1: Initialized to simplify boundary conditions; only used for calculation.
        dp[0] = 1;
        dp[n] = 1;

        // Fill the DP array using the recursive formula:
        // dp[i] = Σ(dp[j] * dp[i - j - 1]) for all valid j.
        // Here, j represents the size of the "inner" range,
        // and (i - j - 1) represents the size of the "outer" range.
        for (int i = 2; i <= n; i++) { // Iterate over the number of strokes (mountain ranges) to calculate.
            for (int j = 0; j < i; j++) { // For each `i`, calculate using subproblems.
                int inside = dp[j];       // Number of ways to form ranges with `j` strokes.
                int outside = dp[i - j - 1]; // Number of ways to form ranges with the remaining strokes.
                dp[i] += inside * outside; // Total for `i` is the sum of products of inner and outer ranges.
            }
        }

        // Return the number of valid mountain ranges for `n` peaks and valleys.
        return dp[n];
    }

    // Main method to test the `countMountainRanges` function.
    public static void main(String[] args) {
        int n = 4; // Number of peaks and valleys.

        // Call the method to calculate the number of valid mountain ranges for `n`.
        int mountainRanges = countMountainRanges(n);

        // Print the result: total number of valid mountain ranges for `n` peaks and valleys.
        System.out.println("Number of mountain ranges: " + mountainRanges);
    }
}
