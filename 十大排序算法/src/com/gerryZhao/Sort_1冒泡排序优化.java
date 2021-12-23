package com.gerryZhao;

/**
 * @ClassName Sort_1冒泡排序优化
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-23 15:11
 * @Version 1.0.0
 */
public class Sort_1冒泡排序优化 {
    /**
     * 记住最后一次交换发生发生位置lastExchange的冒泡排序
     * 在每趟扫描中，记住最后一次交换发生的位置lastExchange，（该位置之后的相邻记录均已有序）。
     * 下一趟排序开始时，R[1...lastExchange]是无序区，R[lastExchange...n]是有序区。
     * 这样，一趟排序可能使当前无序区扩充多个记录，因此记住最后一次交换发生的位置lastExchange，从而减少排序的趟数。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9, 2, 6, 3, 8, 4, 7, 1, 5, 0};
        boolean flag = true;
        int k = nums.length - 1;
        int pos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            flag = true;
            for (int j = 0; j < k; j++) {
                if (nums[j] > nums[j + 1]) {
                    int target = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = target;
                    flag = false;
                    pos = j; // 循环里最后一次交换的位置 j 赋值给pos
                }
            }
            if (flag) {
                break;
            }
            k = pos;
        }

        // 打印数组
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.print(nums[i]);
            } else {
                System.out.print(nums[i] + "->");
            }
        }
    }
}
