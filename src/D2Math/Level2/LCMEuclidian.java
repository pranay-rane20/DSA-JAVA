package D2Math.Level2;


//a*b / gcd(a, b);


public class LCMEuclidian {
    // gcd method returns the GCD of a and b
    static int gcd(int a, int b) {

        // if b=0, a is the GCD
        if (b == 0)
            return a;

            // call the gcd() method recursively by
            // replacing a with b and b with
            // modulus(a,b) as long as b != 0
        else
            return gcd(b, a % b);
    }

    // lcm() method returns the LCM of a and b
    static int lcm(int a, int b, int gcdValue)
    {
        return Math.abs(a * b) / gcdValue;
    }

    // Driver method
    public static void main(String[] args) {

        int a = 20, b = 30, gcdValue;
        gcdValue = gcd(a, b);

        // calling gcd() over
        System.out.println("GCD = " + gcdValue);

        // calling lcm() over integers 30 and 20
        System.out.println("LCM = " + lcm(a, b, gcdValue));
    }
}
