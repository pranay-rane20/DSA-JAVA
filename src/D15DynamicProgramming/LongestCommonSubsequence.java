package D15DynamicProgramming;

//A subsequesce of a string is a new string generated from the original string
//with some character(can be none) deleted without changing the relative
//order of the remaining characters
//str1 = "abcde", str2 = "ace"
//ans = 3 // "ace"
public class LongestCommonSubsequence {

    public static int lcsR(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) return 0;
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcsR(s1, s2, n - 1, m - 1); // Include the matched character
        } else {
            int ans1 = lcsR(s1, s2, n - 1, m); // Skip a character from s1
            int ans2 = lcsR(s1, s2, n, m - 1); // Skip a character from s2
            return Math.max(ans1, ans2); // Take the maximum of both cases
        }
    }
    public static int lcsM(String s1,String s2,int n,int m,int dp[][]){
        if (n == 0 || m == 0) return 0;
        if (dp[n][m]!= -1) {
            return dp[n][m];
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = lcsM(s1, s2, n - 1, m - 1,dp); // Include the matched character
            return 1 + dp[n][m];
        } else {
            int ans1 = lcsM(s1, s2, n - 1, m,dp); // Skip a character from s1
            int ans2 = lcsM(s1, s2, n, m - 1,dp); // Skip a character from s2
            return dp[n][m] =  Math.max(ans1, ans2); // Take the maximum of both cases
        }
    }

    public static int lcsT(String s1,String s2,int n,int m){
        int dp[][] = new int[n][m];
        for(int i=1;i<=n+1;i++){
            for (int j=1;j<=m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2); // Take the maximum of both cases
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int lcsLength = lcsR(str1, str2, str1.length(), str2.length());
        System.out.println("Length of LCS is: " + lcsLength);
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n][m];
        for(int i = 0; i <= n; i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }

    }
}
