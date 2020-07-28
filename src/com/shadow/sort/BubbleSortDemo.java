package com.shadow.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法
 * <p>
 * 时间复杂度:O(n*n)
 * 空间复杂度:1
 * 稳定性：稳定
 * 实现步骤：
 * 1）比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2）对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 3）针对所有的元素重复以上的步骤，除了最后一个。
 * 4）持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 2, 3, 4};
        new BubbleSortDemo().bubbleSort(nums);
    }

    private void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
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
