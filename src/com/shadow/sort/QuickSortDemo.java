package com.shadow.sort;

import java.util.Arrays;

/**
 * 快速排序算法
 * <p>
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(logn)
 * 稳定性：不稳
 * 实现步骤：
 * 1 从数列中挑出一个元素，称为“基准”（pivot），
 * 2 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 3 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * 递归的最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了。虽然一直递归下去，但是这个算法总会退出，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 4, 9, 7, 2, 5, 8, 10};
        new QuickSortDemo().quickSort(nums);
    }

    private void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void quickSort(int[] nums, int lo, int hi) {
        // 数组中就一个元素
        if (lo >= hi) {
            return;
        }
        // 切分
        int j = partition(nums, lo, hi);
        // 将左半边nums[lo..j-1]排序
        quickSort(nums, lo, j - 1);
        quickSort(nums, j + 1, hi);
        // 将右半边nums[j+1..hi]排序
    }

    private int partition(int[] nums, int lo, int hi) {
        // 将数组切分成 a[lo...i-1],a[i],a[i+1..hi]
        // 左右扫描的指针
        int i = lo, j = hi + 1;
        // 将lo位置上的元素作为基准数
        int k = lo;
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (nums[++i] < nums[k]) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] > nums[k]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        // 将nums[k]放入正确的位置
        swap(nums, lo, j);
        // a[lo...j-1],a[j],a[j+1..hi]
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
