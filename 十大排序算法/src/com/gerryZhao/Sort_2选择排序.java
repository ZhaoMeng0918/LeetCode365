package com.gerryZhao;

/**
 * @ClassName Sort_2选择排序
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-23 15:23
 * @Version 1.0.0
 */
public class Sort_2选择排序 {
    /**
     * 选择
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9, 2, 6, 3, 8, 4, 7, 1, 5, 0};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
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
