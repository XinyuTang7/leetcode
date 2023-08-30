package algorithm.arithmetic;

public class Divide {

    //减法效率低,提交后超时
    public static int divide1(int dividend, int divisor) {
        int res = 0;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            while (Math.abs(dividend) >= Math.abs(divisor) || dividend == Integer.MIN_VALUE) {
                dividend -= divisor;
                if (res >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                res++;
            }
        }
        while (Math.abs(dividend) >= Math.abs(divisor) || dividend == Integer.MIN_VALUE) {
            dividend += divisor;
            if (res <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            res--;
        }
        return res;
    }

    public static int divide2(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        int res = 0;
        int navigate = dividend ^ divisor;
        long d = Math.abs((long)dividend);
        long r = Math.abs((long)divisor);
        for (int i = 31; i >= 0; i--) {
            if ((d >> i) >= r) {
                res += 1 << i;
                d -= r << i;
            }
        }
        return navigate < 0 ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(divide2(-1,2));
//        System.out.println(divide2(-10,1));
//        System.out.println(divide2(10,-1));
//        System.out.println(divide2(-10,-1));

        System.out.println(divide2(Integer.MAX_VALUE, 1));
        System.out.println(divide2(Integer.MAX_VALUE, -1));
        System.out.println(divide2(Integer.MIN_VALUE, 1));
        System.out.println(divide2(Integer.MIN_VALUE, -1));
    }
}
