package algorithm.array;

import java.util.Arrays;

public class FindEqualRangeInSortArray {
    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * <p>
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     * <p>
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     */

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        if (nums.length == 1) return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        int L = 0, R = nums.length - 1;
        int left = -1, right = -1;
        while (L <= R) {
            int M = L + (R - L) / 2;
            if (nums[M] == target) {
                left = M;
                right = M;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                while (right <= nums.length - 1 && nums[right] == target) {
                    right++;
                }
                return new int[]{left + 1, right - 1};
            } else if (nums[M] < target) L = M + 1;
            else R = M - 1;
        }
        return new int[]{left, right};
    }

    // 两次二分查找，分开查找第一个和最后一个
    // 时间复杂度 O(log n), 空间复杂度 O(1)
    // [1,2,3,3,3,3,4,5,9]
    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        int last = -1;
        // 找第一个等于target的位置
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                first = middle;
                right = middle - 1; //重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // 最后一个等于target的位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                last = middle;
                left = middle + 1; //重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, -1)));
    }
}
