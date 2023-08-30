package algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class NShapeConversion {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * <p>
     * (0)P      (4)A      (8)H       (12)N
     * (1)A (3)P (5)L (7)S (9)I (11)I (13)G
     * (2)Y      (6)I      (10)R
     * <p>
     * 0P      6I       12N
     * 1A   5L 7S   11I 13G
     * 2Y 4A   8H 10R
     * 3P      9I
     * <p>
     * P     H
     * A   S I
     * Y  I  R
     * P L   I N
     * A     G
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     * <p>
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     */
    public static String nShapeConversion(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            res.add(new StringBuilder());
        }
        int flag = -1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index == 0 || index == numRows - 1) {
                flag = -flag;
            }
            res.get(index).append(s.charAt(i));
            index += flag;
        }

        StringBuilder sb = new StringBuilder();
        res.forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("PAHNAPLSIIGYIR".equals(nShapeConversion("PAYPALISHIRING", 3)));
        System.out.println("PINALSIGYAHRPI".equals(nShapeConversion("PAYPALISHIRING", 4)));
        System.out.println("A".equals(nShapeConversion("A", 1)));
    }
}
