package com.gerryZhao;

/**
 * @ClassName Sort_5快速排序
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-23 16:20
 * @Version 1.0.0
 */
public class Sort_5快速排序 {
    /**
     * 在待排序的数列中，我们首先要找一个数字作为基准数（这只是个专用名词）。
     * 为了方便，我们一般选择第 1 个数字作为基准数（其实选择第几个并没有关系）。
     * 接下来我们需要把这个待排序的数列中小于基准数的元素移动到待排序的数列的左边，
     * 把大于基准数的元素移动到待排序的数列的右边。这时，左右两个分区的元素就相对有序了；
     * 接着把两个分区的元素分别按照上面两种方法继续对每个分区找出基准数，然后移动，直到各个分区只有一个数时为止。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9, 2, 6, 3, 8, 4, 7, 1, 5, 0};
        quickSort(nums, 0, nums.length - 1);

        // 打印数组
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.print(nums[i]);
            } else {
                System.out.print(nums[i] + "->");
            }
        }
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low > high) return;
        int pivot = nums[low], i = low, j = high, tmp;
        while (i < j) {
            while (nums[j] >= pivot && i < j) {
                j--;
            }
            while (nums[i] <= pivot && i < j) {
                i++;
            }
            if (i < j) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        nums[low] = nums[i];
        nums[i] = pivot;
        quickSort(nums, low, i - 1);
        quickSort(nums, j + 1, high);
    }
}
