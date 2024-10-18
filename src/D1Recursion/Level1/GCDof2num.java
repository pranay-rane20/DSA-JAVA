package D1Recursion.Level1;

public class GCDof2num {
    public static int GCD(int a , int b){
        if(b==0) return a ;
        return GCD(b , a%b);
    }
    public static void main(String[] args) {
        GCD(15,30);
        System.out.println(GCD(15,30));
    }
}
