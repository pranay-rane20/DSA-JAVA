package D1Recursion.Level1;

public class OneToN {
    public static void OneToN(int n){
        if(n==0)return;
        OneToN(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        OneToN(5);
    }
}