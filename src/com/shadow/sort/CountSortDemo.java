package com.shadow.sort;

import java.util.Arrays;

public class CountSortDemo {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 2, 6, 3, 4, 6, 5, 9, 8, 7, 6};
        new CountSortDemo().countSort(nums);
    }

    private void countSort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        // 统计数组
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] - min]++;
        }
        // 累计次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        // 原始数组从后往前遍历 可以维持稳定性
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i > -1; i--) {
            result[--counts[nums[i]-min]] = nums[i];
        }
        System.out.println(Arrays.toString(result));
    }
}
