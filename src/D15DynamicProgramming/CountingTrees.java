package D15DynamicProgramming;

// Class to count the number of unique Binary Search Trees (BSTs) that can be formed with n nodes.
public class CountingTrees {

    // Method to calculate the number of unique BSTs for a given number of nodes `n`.
    public static int countTrees(int n) {
        // Dynamic Programming (DP) array to store the count of unique trees for each number of nodes.
        int dp[] = new int[n + 1];

        // Base cases:
        // dp[0] = 1: There's exactly one BST with 0 nodes (an empty tree).
        // dp[1] = 1: There's exactly one BST with 1 node (the single node itself).
        dp[0] = 1;
        dp[1] = 1;

        // Fill the DP array using the recursive formula:
        // dp[i] = Σ (dp[j] * dp[i - j - 1]) for all valid j.
        // Here, j represents the number of nodes in the left subtree, and (i - j - 1) represents the number of nodes in the right subtree.
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int left = dp[j];      // Number of BSTs possible with j nodes on the left.
                int right = dp[i - j - 1]; // Number of BSTs possible with remaining nodes on the right.
                dp[i] += left * right; // Total number of BSTs for `i` nodes is the sum of products of left and right subtrees.
            }
        }

        // Return the total number of unique BSTs that can be formed with `n` nodes.
        return dp[n];
    }

    // Main method to test the `countTrees` function.
    public static void main(String[] args) {
        int n = 4; // Number of nodes
        int[] arr = {1, 2, 3, 4}; // Array of nodes (not used in the function)

        // Print the result: total number of unique BSTs for `n` nodes.
        System.out.println("Number of trees = " + countTrees(n));
    }
}
