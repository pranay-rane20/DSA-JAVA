package D15DynamicProgramming;

//Leetcode -> 44

// This program implements a wildcard pattern matching algorithm.
// It determines if a given text matches a pattern that includes wildcard characters:
// '?' - Matches any single character.
// '*' - Matches any sequence of characters (including an empty sequence).

// Example:
// Text = "baaabab"
// Pattern = "*****ba*****ab"
// Output: true

// Text = "baaabab"
// Pattern = "a*****ab"
// Output: false

public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int n = s.length(); // Length of the input text.
        int m = p.length(); // Length of the pattern.
        boolean dp[][] = new boolean[n + 1][m + 1]; // DP table to store matching results.

        // Initialize DP table.
        dp[0][0] = true; // Empty text matches with an empty pattern.

        // If the text is non-empty but the pattern is empty, it's always false.
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }

        // If the text is empty, handle cases where the pattern contains only '*' characters.
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the DP table for the general cases.
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // Case 1: Characters match or pattern has '?'.
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // Case 2: Pattern has '*'.
                else if (p.charAt(j - 1) == '*') {
                    // '*' can match zero or more characters.
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                // Case 3: No match.
                else {
                    dp[i][j] = false;
                }
            }
        }

        // Return the final result: whether the entire text matches the entire pattern.
        return dp[n][m];
    }

    public static void main(String[] args) {
        // Test cases.
        String text = "baaabab";
        String pattern = "*****ba*****ab";
        System.out.println(isMatch(text, pattern)); // Output: true

        text = "baaabab";
        pattern = "a*****ab";
        System.out.println(isMatch(text, pattern)); // Output: false
    }
}
