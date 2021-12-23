package com.gerryZhao;

/**
 * @ClassName Sort_1冒泡排序
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-23 14:45
 * @Version 1.0.0
 */
public class Sort_1冒泡排序 {
    /**
     * 冒泡排序思路：两两排序，最后冒泡到最后
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9, 2, 6, 3, 8, 4, 7, 1, 5, 0};

        boolean flag = false;
        // 这里为什么 i < nums.length - 1，是因为仅需要比较nums.length - 1次，比如3个元素，只需要比较2次就可以得出结果
        for (int i = 0; i < nums.length - 1; i++) { // i : 记录有多少元素已经排过序了
            flag = true; // 优化
            for (int j = 0; j < nums.length - 1 - i; j++) { // j : 进行每一次的排序
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    flag = false;
                }
            }
            if (flag) { // 如果没交换，说明已经排好序了
                break;
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
