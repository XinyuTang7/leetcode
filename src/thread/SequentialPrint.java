package thread;

public class SequentialPrint {
    /**
     * 给定两个数组,要求按照一定的顺序打印
     * <p>
     * 例:
     * [1,2,3,4,5,6][a,b,c,d,e,f]
     * 输出: 1a2b3c4d5e6f
     *
     * @param nums
     * @param chars
     */


    public void sequentialPrint(int[] nums, char[] chars) {
        Object obj = new Object();
        Thread1 t1 = new Thread1(obj, nums);
        Thread2 t2 = new Thread2(obj, chars);
        t1.start();
        t2.start();
    }

    public class Thread1 extends Thread implements Runnable {
        private int[] nums;
        private final Object object;

        Thread1(Object object, int[] nums) {
            this.object = object;
            this.nums = nums;
        }

        @Override
        public void run() {
            synchronized (object) {
                for (int i = 0; i < nums.length; i++) {
                    try {
                        object.notifyAll();
                        System.out.print(nums[i] + ",");
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public class Thread2 extends Thread implements Runnable {
        public char[] chars;
        private final Object object;

        Thread2(Object object, char[] chars) {
            this.object = object;
            this.chars = chars;
        }

        @Override
        public void run() {
            synchronized (object){
                for (int i = 0; i < chars.length; i++) {
                    try {
                        object.notifyAll();
                        System.out.print(chars[i] + ",");
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SequentialPrint print = new SequentialPrint();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        print.sequentialPrint(nums, chars);
    }
}
