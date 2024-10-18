package D2Math.Level1;

public class AddDigits {
    public static int add(int num){
        int sum = 0;
        while(sum>9 || num>0) {
            if (num == 0) {
                num = sum;
                sum = 0;
            }
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(add(37));
    }
}