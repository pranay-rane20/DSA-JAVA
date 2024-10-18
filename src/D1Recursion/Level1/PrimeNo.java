package D1Recursion.Level1;

public class PrimeNo {
    public static boolean isp(int n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i=3; i<=Math.sqrt(n) ; i=i+2){
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int a = 7;
        System.out.println(isp(a));
        for(int i=0; i<1000 ; i++){
            if(isp(i)) System.out.println(i);
        }


    }
}
