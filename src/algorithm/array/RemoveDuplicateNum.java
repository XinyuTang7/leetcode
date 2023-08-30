package algorithm.array;

public class RemoveDuplicateNum {
    /**
     * 删除有序数组中的重复项
     *
     * @param
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 1, end = 1;
        while (end < nums.length) {
            if (nums[end] != nums[end - 1]) {
                nums[start] = nums[end];
                start++;
            }
            end++;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
