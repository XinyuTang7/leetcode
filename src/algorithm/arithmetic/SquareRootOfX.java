package algorithm.arithmetic;

public class SquareRootOfX {
    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     * <p>
     * 示例 1：
     * 输入：x = 4
     * 输出：2
     * <p>
     * 示例 2：
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     *
     * @param x
     */

    public static int mySqrt(int x) {
        if (x == 0) return 0;
        if (x <= 3) return 1;
        int l = 0,r = x;
        int res = 0;
        while (l <= r) {
            int mid = l + ((r - l)  >> 1);
            if (mid <= x / mid) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(100));
    }
}
