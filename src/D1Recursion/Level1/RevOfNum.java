package D1Recursion.Level1;

public class RevOfNum {
    public static int revers(int n,int rev){
        if(n==0) return rev;
        int temp = n%10;
        rev = rev*10 + temp;
        return revers(n/10,rev);

    }
    public static void main(String[] args) {
        System.out.println(revers(3642,0));
    }
}
