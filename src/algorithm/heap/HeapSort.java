package algorithm.heap;

import algorithm.util.SwapUtil;

public class HeapSort {

    public static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int index = 0;
        int heapSize = arr.length;
        while (heapSize > 0) {
            SwapUtil.swap(arr, index, --heapSize);
            heapIfy(arr, index, heapSize);
        }
    }

    //向上看一眼，如果父节点比自己小则和父节点交换位置，直到根节点
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            SwapUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //往下沉，直到孩子没有比自己大或者没有孩子节点为止
    public static void heapIfy(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int longest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            longest = arr[longest] > arr[index] ? longest : index;
            if (longest == index) {
                break;
            }
            SwapUtil.swap(arr, index, longest);
            index = longest;
            left = 2 * index + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 8, 5, 7, 2};
        heapSort(arr);
        for (int num : arr) {
            System.out.print(num + ",");
        }
    }
}
