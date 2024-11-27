package D15DynamicProgramming;

public class Knapsack01 {

    public static int knapsack(int val[], int wt[], int w, int n) {
        if (w == 0 || n == 0) return 0;
        if (wt[n - 1] <= w) { // valid
            // include
            int ans1 = val[n - 1] + knapsack(val, wt, w - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapsack(val, wt, w, n - 1);

            return Math.max(ans1, ans2);

        } else { // not valid
            return knapsack(val, wt, w, n - 1);
        }
    }

    public static int knapsackM(int val[], int wt[], int w, int n, int dp[][]) {
        if (w == 0 || n == 0) return 0;
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + knapsackM(val, wt, w - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapsackM(val, wt, w, n - 1, dp);
            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];
        } else {
            dp[n][w] = knapsackM(val, wt, w, n - 1, dp);
            return dp[n][w];
        }
    }


    public static int knap(int val[] , int wt[], int W){
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
                    int incProfit = v + dp[i-1][j-w];

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
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int w = 7;
        int dp[][] = new int[val.length + 1][w + 1];
        for (int i = 0; i <= val.length; i++) { // Loop till val.length + 1
            for (int j = 0; j <= w; j++) {     // Correct loop condition
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(val, wt, w, val.length)); // Fixed method name
        System.out.println(knapsackM(val, wt, w, val.length, dp));
    }
}
