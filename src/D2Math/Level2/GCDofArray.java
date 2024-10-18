package D2Math.Level2;


//L-1979.
//Find Greatest Common Divisor of Array

import java.util.Arrays;

public class GCDofArray {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int gcd = 0;
        int n = nums.length;
        int first = nums[0];
        int last = nums[n - 1];
        for (int i = 1; i <= first; i++) {
            if (first % i == 0 && last % i == 0)
                gcd = i;
        }
        return gcd;
    }
}
