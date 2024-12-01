package D15DynamicProgramming;
//Convert string1 to string2 with only insertion and deletion
//print number of deletion and insetion
// s1 = "pear", s2 = "sea"

public class StringConversion {
    public static void main(String[] args) {
        String s1 = "pear";
        String s2 = "sea";

        int deletionsAndInsertions[] = findInsertionsAndDeletions(s1, s2);

        System.out.println("Number of Deletions: " + deletionsAndInsertions[0]);
        System.out.println("Number of Insertions: " + deletionsAndInsertions[1]);
    }

    private static int[] findInsertionsAndDeletions(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Find LCS length
        int lcsLength = findLCS(s1, s2, m, n);

        // Calculate deletions and insertions
        int deletions = m - lcsLength;
        int insertions = n - lcsLength;

        return new int[]{deletions, insertions};
    }

    private static int findLCS(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
