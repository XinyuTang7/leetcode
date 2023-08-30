package algorithm.array;

public class TwoOddNumber {

    /**
     * 给定一个数组，其中有两个数出现奇数次，剩下的全是偶数次，找出这两个数，要求时间复杂度O(N),空间复杂度O(1)
     */
    public static int[] twoOddNumber(int[] arr) {
        int a, b;
        int ans = 0;
        for (int num : arr) {
            // ans = a ^ b;
            ans ^= num;
        }
        //取最右位的1, -a = ~a + 1
        int rightOne = ans & (-ans);
        int number = 0;
        //分两组操作,a和b一定是rightOne位置一个为0，一个为1
        for (int num : arr) {
            if((rightOne & num) != 0){
                //number运算后为a,b中的一个
                number ^= num;
            }
        }
        return new int[]{number,number ^ ans};
    }

    public static void main(String[] args) {

    }
}
