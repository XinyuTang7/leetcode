package algorithm.array;

public class MergeSort2 {

    public static void mergeSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int size = arr.length;
        int N = 1;
        while (N < size) {
            int L = 0;
            while (L < size) {
                int M = L + N - 1;
                if (M >= N) {
                    break;
                }
                //取右组下标,上次的右标加步长有可能超过N-1
                int R = Math.min(L + 1 + N - 1, N - 1);
                //左右组合并
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (N > (size >> 1)) {
                break;
            }
            N <<= 1;
        }
    }

    private static void merge(int[] arr, int L, int M, int R) {
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

    public static void main(String[] args) {
        int arr[] = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(arr);
        for (int num : arr) {
            System.out.print(num + ", ");
        }
    }
}
