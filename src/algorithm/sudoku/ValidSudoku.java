package algorithm.sudoku;

public class ValidSudoku {
    /**
     * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * <p>
     * 示例:
     * {{'5','3','.','.','7','.','.','.','.'}
     * ,{'6','.','.','1','9','5','.','.','.'}
     * ,{'.','9','8','.','.','.','.','6','.'}
     * ,{'8','.','.','.','6','.','.','.','3'}
     * ,{'4','.','.','8','.','3','.','.','1'}
     * ,{'7','.','.','.','2','.','.','.','6'}
     * ,{'.','6','.','.','.','.','2','8','.'}
     * ,{'.','.','.','4','1','9','.','.','5'}
     * ,{'.','.','.','.','8','.','.','7','9'}}
     *
     * @param board
     * @return
     */

    public static boolean isValidSudoku(char[][] board) {
        int R = board.length, C = board[0].length;
        int[][] rows = new int[R][C];
        int[][] columns = new int[R][C];
        int[][][] sub = new int[R / 3][C / 3][R];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '1';
                    rows[i][index]++;
                    columns[j][index]++;
                    sub[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || sub[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'9', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(chars));
    }
}
