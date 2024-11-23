package D15DynamicProgramming;

//count ways to reach the nth stair.
// The person can climb either 1 stair or 2 stair at a time
//n = 5


import java.util.Arrays;

//memoization - 0(n) || recursion (2^N)
public class ClimbingStairs {

    // The person can climb either 1 stair or 2 stair at a time

    public static int countways(int n,int ways[]){
        if(n==0) return 1;
        if(n<0) return 0;

        if(ways[n]!=-1) return ways[n]; // already calculated

        ways[n] = countways(n-1,ways) + countways(n-2,ways);
        return ways[n];  //store the result in memoization table for future use.
    }

    // The person can climb either 1 stair or 2 stair of 3 stair at a time

    public static int countwaysvariation(int n,int ways[]){
        if(n==0) return 1;
        if(n<0) return 0;

        if(ways[n]!=-1) return ways[n]; // already calculated

        ways[n] = countwaysvariation(n-1,ways) + countwaysvariation(n-2,ways) + countwaysvariation(n-3,ways);
        return ways[n];  //store the result in memoization table for future use.
    }

    //Tabulation Method
    public static int countwaysTap(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<n;i++){
            if(i==1) dp[i] = dp[i-1];
            else dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int ways[] = new int[n+1];
        Arrays.fill(ways,-1);
        System.out.println(countways(n,ways));
    }
}
