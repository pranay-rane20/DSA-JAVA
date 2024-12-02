package D15DynamicProgramming;


//Normal recursion
public class LongestCommonSubstring {

    public static int lcssRecursive(String s1, String s2, int n, int m, int count) {
        // Base case: If either string is exhausted
        if (n == 0 || m == 0) {
            return count;
        }

        // If characters match, extend the substring
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            count = lcssRecursive(s1, s2, n - 1, m - 1, count + 1);
        }

        // Explore other possibilities and reset count
        int option1 = lcssRecursive(s1, s2, n, m - 1, 0); // Move left in s2
        int option2 = lcssRecursive(s1, s2, n - 1, m, 0); // Move up in s1

        // Return the maximum of the current count and other possibilities
        return Math.max(count, Math.max(option1, option2));
    }
    public static int lcss(String s1,String s2){  //0(n*m)
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for(int j=0;j<=m;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return ans;
    }
    public static void main(String[] args) {
        String s1 = "ABCDE";
        String s2 = "ABGCE";
        System.out.println(lcss(s1,s2));

        int n = s1.length();
        int m = s2.length();
        // Call the recursive function
        int result = lcssRecursive(s1, s2, n, m, 0);
        System.out.println("Length of Longest Common Substring: " + result);

    }
}
