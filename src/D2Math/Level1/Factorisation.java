package D2Math.Level1;

public class Factorisation {
    public static void main(String[] args) {
        int n=100;

        for(int i=1; i<=Math.sqrt(n) ; i++){
            if(n%i==0){
                System.out.println(i);
                if(i*i != n)
                    System.out.println(n/i);

            }
        }
    }
}