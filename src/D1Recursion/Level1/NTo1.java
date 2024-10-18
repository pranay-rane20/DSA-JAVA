package D1Recursion.Level1;

public class NTo1 {
    public static void NTo1(int n){
        if(n==0)return;
        System.out.println(n);

        NTo1(n-1);
    }

    public static void main(String[] args) {
        NTo1(5);
    }

}
