package algorithm.array;

public class ContainerHoldsWater {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     */

    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                res = Math.max(res, (j - i) * Math.min(height[j], height[i]));
            }
        }
        return res;
    }

    public static int maxArea2(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int res = 0;
        int L = 0;
        int R = height.length - 1;
        while (L < R) {
            res = Math.max(res, (R - L) * Math.min(height[R], height[L]));
            if (height[L] < height[R]) {
                L++;
            } else {
                R--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
        System.out.println(maxArea2(arr));
    }
}
