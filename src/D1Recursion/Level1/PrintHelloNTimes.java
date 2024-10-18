package D1Recursion.Level1;


public class PrintHelloNTimes {
    public static void print (int n){
        if(n==0) return;
        System.out.println("hello");
        print(n-1);
    }


    public static void main(String[] args) {
        print(5);

    }
}
