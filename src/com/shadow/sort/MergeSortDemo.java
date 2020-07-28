package com.shadow.sort;

import java.util.Arrays;

/**
 * 归并排序算法
 * <p>
 * 时间复杂度：nlogn
 * 空间复杂度：n
 * 稳定性：稳定
 * 实现步骤：
 * 1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 4. 重复步骤3直到某一指针达到序列尾
 * 5. 将另一序列剩下的所有元素直接复制到合并序列尾
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 4, 9, 7, 2, 5, 8, 10};
        new MergeSortDemo().mergeSort(nums);
    }

    private int[] aux;

    public void mergeSort(int[] nums) {
        aux = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * @param nums 需要排序的数组
     * @param lo   左边
     * @param hi   左边
     */
    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // 左边排序
        mergeSort(nums, lo, mid);
        // 右边排序
        mergeSort(nums, mid + 1, hi);
        // 归并结果
        merge2(nums, lo, mid, hi);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 归并算法
     *
     * @param nums 需要合并的数组
     * @param lo   左边
     * @param mid  中间
     * @param hi   右边
     */
    private void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            // 将nums[lo..hi]复制到aux[lo..hi]
            aux[k] = nums[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                // 左半边用尽
                nums[k] = aux[j++];
            } else if (j > hi) {
                // 右半边用尽
                nums[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                // 右半边的当前元素小于左半边的当前元素
                nums[k] = aux[j++];
            } else {
                // 右半边的当前元素大于等于左半边的当前元素
                nums[k] = aux[i++];
            }
        }
    }

    private void merge2(int[] nums, int lo, int mid, int hi) {
        // 保留传入的lo mid hi的值
        // i:左半边的指针 j:右半边的指针
        int i = lo, j = mid + 1;
        // 将nums[lo...hi]复制到aux[lo...hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }
        // k:合并后的指针
        int k = lo;
        while (i <= mid && j <= hi) {
            if (aux[i] < aux[j]) {
                // 右半边的当前元素小于左半边的当前元素
                nums[k++] = aux[i++];
            } else {
                // 右半边的当前元素小于左半边的当前元素
                nums[k++] = aux[j++];
            }
        }
        while (i <= mid) {
            nums[k++] = aux[i++];
        }
        while (j <= hi) {
            nums[k++] = aux[j++];
        }
    }
}
