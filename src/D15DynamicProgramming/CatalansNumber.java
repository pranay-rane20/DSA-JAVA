package D15DynamicProgramming;
//c0 = 1, c1 = 1
// c2 = c0c1+c1c0 = 2;
//c3 = c0c2 + c1c1 + c2c0 = 5;

import java.util.Arrays;

public class CatalansNumber {
    public static int catR(int n){
        if(n==0 || n==1) return 1;
        int ans = 0;
        for(int i=0;i<=n-1;i++){
            ans += catR(i) * catR(n-1-i);
        }
        return ans;
    }

    public static int catM(int n,int [] dp){
        if(n==0 || n==1) return 1;
        if(dp[n]!=0) return dp[n];
        int ans = 0;
        for(int i=0;i<=n-1;i++){
            ans += catR(i) * catR(n-1-i);
        }
        return dp[n] = ans;
    }

    public static int catT(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Catalan number for " + n + " is " + catR(n));

        int dp[] = new int[n+1];
        Arrays.fill(dp,0);
        System.out.println("Catalan number for " + n + " using Memoization is " + catM(n, dp));
    }

}
