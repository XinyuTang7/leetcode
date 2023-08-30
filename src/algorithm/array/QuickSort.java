package algorithm.array;

import algorithm.util.SwapUtil;

public class QuickSort {
    /**
     * 荷兰国旗问题
     * 4,3,5,4
     *
     * @param
     */

    public static void quicksort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    //快排2.0
    private static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalArea = equalLength(arr, L, R);
        process1(arr, L, equalArea[0] - 1);
        process1(arr, equalArea[1] + 1, R);
    }

    //快排3.0
    private static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        SwapUtil.swap(arr, (int) (L + Math.random() * (R - L + 1)), R);
        int[] equalArea = equalLength(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);
    }

    public static int[] equalLength(int[] arr, int L, int R) {
        if (L == R) {
            return new int[]{L, L};
        }
        int index = 0;
        int less = L - 1;
        int more = R;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                SwapUtil.swap(arr, index++, ++less);
            } else {
                SwapUtil.swap(arr, index, --more);
            }
        }
        SwapUtil.swap(arr, more, R);
        return new int[]{less + 1, more};
    }


    public static void main(String[] args) {
        int arr[] = new int[]{4, 3, 5, 4};
        equalLength(arr,0,3);
//        quicksort(arr);
//        for (int num : arr) {
//            System.out.print(num + ",");
//        }
    }
}
