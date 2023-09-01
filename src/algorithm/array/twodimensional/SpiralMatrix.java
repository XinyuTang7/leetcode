package algorithm.array.twodimensional;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * 1->2->3
     * |     |
     * 4  5  6
     * |     |
     * 7<-8<-9
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int L = 0, R = matrix[0].length - 1, T = 0, B = matrix.length - 1;
        int sum = (R + 1) * (B + 1), num = 0;
        List<Integer> res = new ArrayList<>();
        while (num < sum) {
            for (int i = L; i <= R; i++) {
                num++;
                res.add(matrix[L][i]);
            }
            if(num == sum)break;
            T++;
            for (int i = T; i <= B; i++) {
                num++;
                res.add(matrix[i][R]);
            }
            if(num == sum)break;
            R--;
            for (int i = R; i >= L; i--) {
                num++;
                res.add(matrix[B][i]);
            }
            if(num == sum)break;
            B--;
            for (int i = B; i >= T; i--) {
                num++;
                res.add(matrix[i][L]);
            }
            if(num == sum)break;
            L++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] nums = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(nums));
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                System.out.print(nums[i][j] + ",");
//            }
//            System.out.println();
//        }
    }
}
