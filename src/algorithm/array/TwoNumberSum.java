package algorithm.array;

import java.util.HashMap;

public class TwoNumberSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
                return new int[]{map.get(nums[i]), map.get(target - nums[i])};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int[] res = twoSum(arr,9);
        for (int re : res){
            System.out.print(re + ", ");
        }

    }
}
