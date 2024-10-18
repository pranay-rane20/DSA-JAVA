package D2Math.Level2;
import java.util.Arrays;

//L-204
//--Sieve of Eratosthenes
//--complexity O(n log(log(n))

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        int count=0;
        for(int i=2; i<=Math.sqrt(n) ; i++){
            if(isPrime[i]){
                for(int j=i*2 ; j<n ; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i=2; i<n ; i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
}