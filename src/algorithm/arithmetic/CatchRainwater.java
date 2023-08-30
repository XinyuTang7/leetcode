package algorithm.arithmetic;

import java.util.HashMap;
import java.util.Map;

public class CatchRainwater {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     *输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
     * @param
     */

    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int highest = 0, highestIndex = 0, first = 0, last = height.length - 1;
        int riseArea = 0, declineArea = 0, heightArea = 0;
        boolean flag = true;
        Map<Integer, Integer> riseMap = new HashMap<>();
        Map<Integer, Integer> declineMap = new HashMap<>();
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0 && flag) {
                first = i;
                flag = false;
            }
            if (height[i] > 0) {
                last = i;
            }
            highest = Math.max(highest, height[i]);
            highestIndex = i;
            heightArea += height[i];
        }
        int maxArea = (last - first + 1) * highest;
        for (int i = first; i <= last; i++) {
            if (height[i] > height[first] && !riseMap.containsKey(height[i]) && i <= highestIndex) {
                riseMap.put(height[i], i);
            }
            if (height[i] > height[last] && i >= highestIndex) {
                declineMap.put(height[i], i);
            }
        }
        for (int i : riseMap.keySet()) {
            riseArea += (riseMap.get(i) - first) * (i - height[first]);
        }
        for (int i : declineMap.keySet()) {
            declineArea += (last - declineMap.get(i)) * (i - height[last]);
        }
        return maxArea - riseArea - declineArea - heightArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
