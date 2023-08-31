package algorithm.arithmetic;

public class NthPower {

    /**
     * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
     * <p>
     * 示例 1：
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * <p>
     * 示例 2：
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     * <p>
     * 示例 3：
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow1(double x, int n) {
        long N = n;
        if (N == 0 || x == 1) return 1;
        if (x == 0) return 0;
//        if (n == Integer.MIN_VALUE && x == -1) return -1;
        long m = N > 0 ? N : -N;
        double res = 1;
        if (x == -1) return m % 2 == 0 ? 1 : -1;
        while (m > 0) {
            res *= x;
            m--;
        }
        return n > 0 ? res : 1.0 / res;
    }

    public static double myPow2(double x, int n) {
        long N = n;
        return N > 0 ? process(x, N) : 1.0 / process(x, -N);
    }

    public static double process(double x, long n) {
        if (n == 0) return 1;
        double res = process(x, n / 2);
        return n % 2 == 0 ? res * res : res * res * x;
    }

    public static void main(String[] args) {
//        System.out.println(myPow(2.00000, 10));
//        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow2(-1, -2147483648));

//        System.out.println(myPow(0, 0) + "," + Math.pow(0, 0));
//        System.out.println(Integer.MAX_VALUE);
    }
}
