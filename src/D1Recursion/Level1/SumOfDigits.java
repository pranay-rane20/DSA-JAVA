package D1Recursion.Level1;

public class SumOfDigits {
    public static int sumofdigits(int n){
        if(n<10) return n;
        int temp = n%10;
        return temp + sumofdigits(n/10);
    }
    public static void main(String[] args) {
        System.out.println(sumofdigits(1123));
    }
}
