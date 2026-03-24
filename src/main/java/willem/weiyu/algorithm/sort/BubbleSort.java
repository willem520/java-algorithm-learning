package willem.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换
 *
 */
public class BubbleSort extends BaseSort {

    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param array 待排序数组
     */
    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        System.out.println("冒泡排序前=>" + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("冒泡排序后=>" + Arrays.toString(array));
    }
}
