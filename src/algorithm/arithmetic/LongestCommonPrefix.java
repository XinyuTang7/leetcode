package algorithm.arithmetic;

public class LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""
     *
     * @param
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return str.substring(0, i);
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flow", "flo", "flower"};
        System.out.println(longestCommonPrefix(strs));
    }
}
