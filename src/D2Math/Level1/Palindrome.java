package D2Math.Level1;

public class Palindrome {   public static boolean isp(int x){
    int rev = 0;
    int dup = x;
    while(x>0){
        int rem = x%10;
        rev = rev*10 + rem;
        x=x/10;
    }
    return rev==dup;
}
    public static void main(String[] args) {
        System.out.println(isp(1331));
    }
}