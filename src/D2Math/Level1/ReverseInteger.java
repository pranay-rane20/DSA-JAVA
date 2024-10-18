package D2Math.Level1;

public class ReverseInteger {
    public static int rev(int n){
    int r =0;
    while(n!=0){
        r = (r*10) + n%10;
        n /= 10;
    }
    return r;
}
    public static void main(String[] args) {
        System.out.println(rev(1343));
    }
}