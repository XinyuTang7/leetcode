package algorithm.dynprogram;

public class DynamicProgramming1 {
    /**
     * 1 2 3 4 5 6 7 8
     * 给定一组数字，假设此时起点位置为start,目标位置为target,一共可以走rest步,求一共有多少中方式
     * 2->3->4->5->4
     * 2->3->4->3->4
     * 2->3->2->3->4
     * 2->1->2->3->4
     *
     * @return
     */

    public static int dynamicProgramming1(int start, int target, int rest, int n) {
        return process1(start, target, rest, n);
    }

    public static int dynamicProgramming2(int start, int target, int rest, int n) {
        int[][] dp = new int[start + 1][rest + 1];
        for (int i = 0; i <= start; i++) {
            dp[i][0] = start == target ? 1 : 0;
            for (int j = 1; j <= rest; j++) {
//                dp[i][j] =
            }
        }
        return process2(start, target, rest, n, dp);
    }

    public static int process1(int curr, int target, int rest, int n) {
        if (rest == 0) {
            return curr == target ? 1 : 0;
        }
        if (curr == 1) {
            return process1(curr + 1, target, rest - 1, n);
        }
        if (curr == n - 1) {
            return process1(curr - 1, target, rest - 1, n);
        }
        return process1(curr - 1, target, rest - 1, n) + process1(curr + 1, target, rest - 1, n);
    }

    public static int process2(int curr, int target, int rest, int n, int[][] dp) {

        if (rest == 0) {
            return curr == target ? 1 : 0;
        }
        if (curr == 1) {
            return process1(curr + 1, target, rest - 1, n);
        }
        if (curr == n - 1) {
            return process1(curr - 1, target, rest - 1, n);
        }
        return process1(curr - 1, target, rest - 1, n) + process1(curr + 1, target, rest - 1, n);
    }


    public static void main(String[] args) {
        System.out.println(dynamicProgramming1(2, 4, 6, 8));
    }
}
