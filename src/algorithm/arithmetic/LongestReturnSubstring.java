package algorithm.arithmetic;

public class LongestReturnSubstring {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     */
    public static String longestReturnSubstring(String s) {
        int temp;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getLength(s, i, i);
            int len2 = getLength(s, i, i + 1);
            temp = Math.max(len1, len2);
            if (temp > end - start) {
                start = i - (temp - 1) / 2;
                end = i + temp / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int getLength(String s, int L, int R) {
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String res = longestReturnSubstring("121");
        System.out.println(res);
    }
}
