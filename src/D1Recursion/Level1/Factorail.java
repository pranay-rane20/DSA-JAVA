package D1Recursion.Level1;

public class Factorail {
    public static int fac(int n){
        if(n<=1) return n;
        return n * fac(n-1);
    }
    public static void main(String[] args) {
        System.out.println(fac(5));
    }
}
