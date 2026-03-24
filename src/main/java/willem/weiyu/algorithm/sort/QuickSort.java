package willem.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分
 *
 */
public class QuickSort extends BaseSort {

    /**
     * 时间复杂度O(nlogn)
     * 空间复杂度O(logn)
     * @param array 待排序数组
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        //选基准值
        int baseNum = array[start];
        int i = start;
        int j = end;
        while (i < j) {
            //先看右边，依次往左递减
            while (baseNum <= array[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (baseNum >= array[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                swap(array, i, j);
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        array[start] = array[i];
        array[i] = baseNum;
        //递归调用左半数组
        quickSort(array, start, j - 1);
        //递归调用右半数组
        quickSort(array, j + 1, end);
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        System.out.println("快速排序前=>" + Arrays.toString(array));
        quickSort(array);
        System.out.println("快速排序后=>" + Arrays.toString(array));
    }
}
