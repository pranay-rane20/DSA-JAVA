package D2Math.Level1;

public class FactorsOfNum {
    public static void linear(int n){
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
                System.out.print(i + " ");
    }
    public static int sqrt(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println(i);
                if (i * i != n)
                    System.out.println(n / i);

            }
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
