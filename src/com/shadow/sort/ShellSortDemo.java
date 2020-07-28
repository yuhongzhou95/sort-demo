package com.shadow.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 希尔排序
 * <p>
 * 时间复杂度：n的1.3次方
 * 空间复杂度：1
 * 稳定性：不稳定
 * 实现步骤：
 * 1）选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 2）按增量序列个数k，对序列进行k 趟排序；
 * 3）每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSortDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 2, 3, 4};
        new ShellSortDemo().shellSort(nums);
    }

    private void shellSort(int[] nums) {
        List<Integer> stepSequence = shellStepSequence(nums);
        for (Integer step : stepSequence) {
            sort(nums, step);
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     *
     * @param nums
     * @param step 步长
     */
    private void sort(int[] nums, int step) {
        for (int i = step; i < nums.length; i++) {
            for (int j = i; j > step - 1; j -= step) {
                if (nums[j] < nums[j - step]) {
                    swap(nums, j, j - step);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 希尔步长序列
     * 类似于 1,2,4,8,16
     *
     * @param nums
     * @return
     */
    private List<Integer> shellStepSequence(int[] nums) {
        ArrayList<Integer> stepSequence = new ArrayList<>();
        int step = nums.length;
        while ((step >>= 1) > 0) {
            stepSequence.add(step);
        }
        return stepSequence;
    }
}
