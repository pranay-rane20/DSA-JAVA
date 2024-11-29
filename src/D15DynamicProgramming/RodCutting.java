package D15DynamicProgramming;

//Given a rod of length n inches and an array of prices that includes prices of
//size smaller than n .
//Determine the max val obtain by cutting up the rod and selling the pieces.

public class RodCutting {

    public static int maxval(int len[], int p[], int rl){
        int n = len.length;
        int dp[][] = new int[n+1][rl+1];
        for(int i = 0; i < n+1; i++){
            dp[i][0] = 1;
        }

        for(int j = 1; j < rl+1; j++){
            dp[0][j] = 0;
        }

        for (int i=1;i<=n+1;i++){
            for(int j=1;j<=rl+1;j++){
                //valid
                if(len[i-1]<=j){
                    //include
                    dp[i][j] = Math.max(p[i-1] + dp[i][j-len[i-1]], dp[i-1][j]);
                    //exclude
                }else{ //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rl];
    }

    public static void main(String[] args) {
        int length[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int rodlength = 8;

    }
}
