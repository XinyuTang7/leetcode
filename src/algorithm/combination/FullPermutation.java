package algorithm.combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FullPermutation {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * @param nums
     * @return
     */

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(Collections.singletonList(nums[0]));
            return res;
        }
        process(nums, res, 0);
        return res;
    }

    static List<Integer> temp = new ArrayList<>();

    private static void process(int[] nums, List<List<Integer>> res, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {
            if (!temp.contains(num)) {
                temp.add(num);
                process(nums, res, index + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res.size());
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }
}
