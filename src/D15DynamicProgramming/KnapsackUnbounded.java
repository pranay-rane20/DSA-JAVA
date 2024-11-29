package D15DynamicProgramming;

public class KnapsackUnbounded {
    public static int unboundedKnapsack(int val[] , int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<=n+1;i++){
            for(int j=1;j<W+1;j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w<=j){
                    int incProfit = v + dp[i][j-w];

                    int excProfit = dp[i-1][j];

                    dp[i][j] = Math.max(incProfit, excProfit);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];  // Fixed variable name and added return statement
    }

    public static void main(String[] args) {
        int W = 8; // Knapsack capacity
        int[] wt = {1, 3, 4, 5}; // Weights of items
        int[] val = {10, 40, 50, 70}; // Values of items
        int n = wt.length;

        System.out.println("Maximum value: " + unboundedKnapsack(val,wt,W));
    }
}
