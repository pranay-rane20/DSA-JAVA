package D1Recursion.Level1;

public class SumOfN {
    public static int sum(int n){
        if(n<=1) return n;
        return n + sum(n-1);
    }

    public static void main(String[] args) {
//        sum(10);
        System.out.println(sum(10));
    }
}
