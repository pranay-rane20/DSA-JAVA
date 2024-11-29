package D15DynamicProgramming;

public class TargetSumSubset {
    public static boolean TSS(int num[],int t){
        int n = num.length;
        boolean dp[][] = new boolean[n+1][t+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = true;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = false;
        }
        for(int i=1;i<=n+1;i++){
            for(int j=1;j<=t+1;j++){
                int v = num[i-1];
                    //include
                    if(v<=j && dp[i-1][j-v] == true){
                        dp[i][j] = true;
                    }
                    //exclude
                    else if(dp[i-1][j]==true){
                        dp[i][j] = true;
                    }

            }
        }
        return dp[n][t];
    }
    public static void main(String[] args) {
        int num[] = {4,2,7,1,3};
        int t = 10;

    }
}
