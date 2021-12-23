package com.gerryZhao;

/**
 * @ClassName Sort_3插入排序
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-23 15:47
 * @Version 1.0.0
 */
public class Sort_3插入排序 {
    /**
     * 插入排序
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9, 2, 6, 3, 8, 4, 7, 1, 5, 0};
        int tmp, i, j;
        for (i = 1; i < nums.length; i++) {
            tmp = nums[i];
            for (j = i - 1; j >= 0 && nums[j] > tmp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = tmp;
        }

        // 打印数组
        for (i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.print(nums[i]);
            } else {
                System.out.print(nums[i] + "->");
            }
        }
    }
}
