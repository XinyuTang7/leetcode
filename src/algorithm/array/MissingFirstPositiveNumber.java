package algorithm.array;

import java.util.HashMap;
import java.util.Map;

public class MissingFirstPositiveNumber {

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * <p>
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,0]
     * 输出：3
     * <p>
     * 示例 2：
     * <p>
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     *
     * @param nums
     * @return
     */

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        if (nums.length == 1) return nums[0] == 1 ? 2 : 1;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 1; j <= nums.length; j++) {
            if (!map.containsKey(j)) {
                return j;
            }
            if (j == nums.length) {
                return j + 1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        System.out.println(firstMissingPositive(nums));
    }
}
