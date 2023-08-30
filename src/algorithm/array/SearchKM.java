package algorithm.array;

public class SearchKM {
    /**
     * 给定一个数组，在数组中有一种数出现K次，其余的数出现M次，找出出现K次的数，其中K<M，M >1，要求时间复杂度O(N),空间复杂度O(1)
     */
    public static int searchKM(int arr[], int k, int m) {
        //1.初始化一个32位的数组,t[i]表示i位置包含1的个数
        // 00011 3次
        // 00100 4次
        // 00101 4次
        // 11111 4次
        int t[] = new int[32];
        for (int i = 0; i < t.length; i++) {
            for (int num : arr) {
                if (((num >> i) & 1) != 0) {
                    t[i]++;
                }
            }
        }
        //2.遍历32位数组,将出现K次的数取出
        int res = 0;
        for (int i = 0; i <= t.length - 1; i++) {
            //t[i]有1
            if ((t[i] % m) != 0) {
                //t[i]位有1,将1向左移动i位，怼到res中
                res |= (1 << i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{ -1,-1,-1,-1,3, 3, 4, 4, 5, 3, 5, 5, 4, 4, 5};
        System.out.println(searchKM(arr, 3, 4));
    }

}
