package willem.weiyu.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
 * 将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，
 * 这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了。
 */
public class HeapSort extends BaseSort {

    /**
     * 时间复杂度：O(nlogn)，n 为数组长度
     * 空间复杂度：O(1)
     */
    public static void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        buildMaxHeap(nums);

        // 每一轮把堆顶最大值放到末尾，然后修复剩余区间的大顶堆。
        for (int heapSize = nums.length; heapSize > 1; heapSize--) {
            swap(nums, 0, heapSize - 1);
            siftDown(nums, 0, heapSize - 1);
        }
    }

    /**
     * 从最后一个非叶子节点开始下沉，构建初始大顶堆。
     */
    private static void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            siftDown(nums, i, nums.length);
        }
    }

    /**
     * 让 root 节点在 [0, heapSize) 内下沉到正确位置，维持大顶堆性质。
     */
    private static void siftDown(int[] nums, int root, int heapSize) {
        int current = root;
        while (true) {
            int left = 2 * current + 1;
            int right = left + 1;
            int largest = current;

            if (left < heapSize && nums[left] > nums[largest]) {
                largest = left;
            }
            if (right < heapSize && nums[right] > nums[largest]) {
                largest = right;
            }

            if (largest == current) {
                return;
            }

            swap(nums, current, largest);
            current = largest;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{20, 7, 28, 32, 1, 9, 5, 2};
        System.out.println("堆排序前=>" + Arrays.toString(array));
        heapSort(array);
        System.out.println("堆排序后=>" + Arrays.toString(array));
    }
}
