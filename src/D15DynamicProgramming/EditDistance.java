package D15DynamicProgramming;
//given two word , return the mini number of operstaion required to convert word1 to word2
//you have the following opertions permitted on a word
//insert a char
//delete a char
//replace a char
//s1 = "intention" , s2 = "execution"

import java.util.Arrays;

public class EditDistance {

    public static int editDistanceMemo(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        // Initialize memoization table with -1
        int[][] memo = new int[n + 1][m + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(s1, s2, n, m, memo);
    }

    private static int helper(String s1, String s2, int n, int m, int[][] memo) {
        // Base cases
        if (n == 0) return m; // If s1 is empty, insert all remaining chars of s2
        if (m == 0) return n; // If s2 is empty, remove all remaining chars of s1

        // If the result is already calculated, return it
        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            // Characters match, move to the next
            memo[n][m] = helper(s1, s2, n - 1, m - 1, memo);
        } else {
            // Calculate all possible operations
            int insert = helper(s1, s2, n, m - 1, memo) + 1;
            int delete = helper(s1, s2, n - 1, m, memo) + 1;
            int replace = helper(s1, s2, n - 1, m - 1, memo) + 1;
            // Take the minimum of the three operations
            memo[n][m] = Math.min(insert, Math.min(delete, replace));
        }
        return memo[n][m];
    }
    public static int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int rep = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(add,Math.min(del,rep));
                }
            }
        }
        return dp[n][m];

    }
    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(editDistance(s1, s2));
    }
}
