package com.shadow.sort;

import java.util.Arrays;

/**
 * 选择排序算法
 * <p>
 * 时间复杂度：O(n*n)
 * 空间复杂度：1
 * 稳定性：不稳定
 * 实现步骤：
 * 1）首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 2）再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 3）重复第二步，直到所有元素均排序完毕。
 */
public class SelectionSortDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 2, 3, 4};
        new SelectionSortDemo().selectionSort(nums);
    }

    private void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                minIndex = nums[minIndex] > nums[j] ? j : minIndex;
            }
            if (i != minIndex) {
                swap(nums, i, minIndex);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
