package com.shadow.sort;

import java.util.Arrays;

/**
 * 插入排序算法
 * <p>
 * 时间复杂度:O(n*n)
 * 空间复杂度:1
 * 稳定性：稳定
 * 实现步骤：
 * 1）将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * 2）从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class InsertionSortDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 2, 3, 4};
        new InsertionSortDemo().insertionSort(nums);
    }

    private void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 如果当前数组位置的元素小于前一个位置的元素，才插入
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                // 将a[i]插入到a[i-1]、a[i-2]、a[i-3]…之中
                swap(nums, j, j - 1);
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
