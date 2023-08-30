package algorithm.stack;

import java.util.*;

public class GenerateBracket {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     */
    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        char[] chars = new char[]{'(', ')'};
        process(chars, 0, res, 2 * n);
        return res;
    }

    static StringBuilder temp = new StringBuilder();

    private static void process(char[] chars, int index, List<String> res, int n) {
        if (index == n) {
//            if (validBracket(temp.toString())) {
//                res.add(temp.toString());
//            }
            res.add(temp.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            temp.append(chars[i]);
            process(chars, index + 1, res, n);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static boolean validBracket(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || map.get(s.charAt(i)) != stack.peek()) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static boolean validBracket1(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        // (()))(
        char[] chars = s.toCharArray();
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                num1++;
            } else {
                num2++;
            }
            if(num1 < num2){
                return false;
            }
        }
        return num1 == num2;
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for (String str : list) {
            System.out.println(str + ": " + validBracket1(str));
        }
    }
}
