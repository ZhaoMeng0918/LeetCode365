package com.gerryZhao;

/**
 * @ClassName Sort_希尔排序
 * @Description TODO
 * @Author Administrator
 * @Date 2021-12-23 16:05
 * @Version 1.0.0
 */
public class Sort_4希尔排序 {
    /**
     * 希尔排序是把序列按下标的一定增量分组，对每组使用直接插入排序算法排序；
     * 随着增量的逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个序列恰好被分为一组，算法便终止。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{9, 2, 6, 3, 8, 4, 7, 1, 5, 0};
        int tmp, i, j;
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (i = gap; i < nums.length; i++) {
                tmp = nums[i];
                for (j = i - gap; j >= 0 && nums[j] > tmp; j -= gap) {
                    nums[j + gap] = nums[j];
                }
                nums[j + gap] = tmp;
            }
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
