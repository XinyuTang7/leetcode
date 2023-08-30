package algorithm.combination;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * @param digits
     */
    public static List<String> combination(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        String[] nums = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        lookBack(nums, 0, digits, res);
        return res;
    }

    static StringBuilder temp = new StringBuilder();

    public static void lookBack(String[] nums, int index, String digits, List<String> res) {
        if (index == digits.length()) {
            res.add(temp.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String str = nums[digit];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            lookBack(nums, index + 1, digits, res);
            //回溯
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> combination = combination("2");
        for (String str: combination) {
            System.out.print(str + ",");
        }
    }
}
