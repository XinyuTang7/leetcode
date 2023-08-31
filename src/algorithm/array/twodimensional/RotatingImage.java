package algorithm.array.twodimensional;


public class RotatingImage {
    /**
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     *
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     *
     *示例 1：
     *      1,2,3           7,4,1
     *      4,5,6           8,5,2
     *      7,8,9           9,6,3
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[7,4,1],[8,5,2],[9,6,3]]
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        //分析发现规律为(i,j) -> (j,n-1-i)
        //等价于(i,j) ->  (n-1-i,j)  -> (j,n-1-i)
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - i][j];
                matrix[len - 1 - i][j] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        //[1,2,3],[4,5,6],[7,8,9]
        int[][]nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[i][j] + ",");
            }
            System.out.println();
        }
    }
}
