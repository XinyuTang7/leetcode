package algorithm.arithmetic;

public class FirstIndexOf {
    /**
     * KMP算法求出现的下标
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0) return -1;
        if (needle.length() > haystack.length()) return -1;
        int[] temp = getNextArray(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (temp[j] == -1) {
                i++;
            } else {
                j = temp[j];
            }
        }
        return haystack.indexOf(needle);
    }

    public static int[] getNextArray(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        if (needle.length() == 1) return next;
        next[1] = 0;
        int i = 2, cn = next[i - 1];
        while (i < needle.length()){
            if(needle.charAt(i -1) == needle.charAt(cn)) next[i++] = ++cn;
            else if (cn == 0)  next[i++] = 0;
            else cn = next[cn];
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "but"));
        //abbsabbucabbsabbex
    }
}
