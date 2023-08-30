package algorithm.array;

public class IntegerInversion {

    //反转整数 821 = 8 * 100 + 2 * 10 + 1
    //反转整数 128 = 1 * 100 + 2 * 10 + 8 * 1
    public static int integerInversion(int x) {
        if (x == 0) {
            return 0;
        }
        long res = 0;
        int pow = String.valueOf(Math.abs(x)).length();

        int[] arr = new int[pow];

        while (x != 0) {
            int mod = x % 10;
            x /= 10;
            arr[--pow] = mod;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            res += arr[i] * Math.pow(10, i);
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return 0;
        }
        return (int)res;
    }

    public static int reverse(int x){
        long n = 0;
        while(x != 0){
            n = n * 10 + x % 10;
            x /= 10;
        }
        return (int)n;
    }

    public static int reverse2(int x){
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(integerInversion(-1111999999));
    }
}
