package algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MergeSort {

    public static void mergeSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int arr[], int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int P1 = L;
        int P2 = M + 1;
        int i = 0;
        while (P1 <= M && P2 <= R) {
            help[i++] = arr[P1] >= arr[P2] ? arr[P2++] : arr[P1++];
        }
        while (P1 <= M) {
            help[i++] = arr[P1++];
        }
        while (P2 <= R) {
            help[i++] = arr[P2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[j + L] = help[j];
        }
    }

    public static void logarithmicPhase(int arr[]) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
//        int arr[] = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
//        mergeSort(arr);
//        for (int a : arr) {
//            System.out.print(a + ", ");
//        }
        //生成50w个随机长度[100,200)的数组
        //每个数组的数值随机[-200,200]
        int number = 50000;
        int length = 100;
        int value = 200;
        List<int[]> list = generateArray(number, length, value);
        for (int arr[] : list) {
            int[] arr1 = arr;
            logarithmicPhase(arr1);
            int[] arr2 = arr;
            mergeSort(arr2);
            if (!Arrays.equals(arr1, arr2)) {
                System.out.println("错误");
            }
        }
    }

    private static List<int[]> generateArray(int number, int length, int value) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Random random = new Random();
            int len = random.nextInt(length) + length;
            int[] arr = new int[len];
            assignValue(arr, len, value);
            list.add(arr);
        }
        return list;
    }

    private static void assignValue(int[] arr, int len, int value) {
        for (int i = 0; i < len; i++) {
            Random random = new Random();
            arr[i] = (random.nextInt(value) + 1) - (random.nextInt(value) + 1);
        }
    }


}
