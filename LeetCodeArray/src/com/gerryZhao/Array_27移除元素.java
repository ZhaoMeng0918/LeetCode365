package com.gerryZhao;

/**
 * @ClassName Array_27移除元素
 * @Description TODO
 * @Author Administrator
 * @Date 2022-01-04 11:20
 * @Version 1.0.0
 */
public class Array_27移除元素 {
    // 反手就是一个快慢指针
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int slow = 0, fast = nums.length - 1;
        while (slow <= fast) {
            if (nums[slow] != val) {
                slow++;
                continue;
            }
            if (nums[fast] == val) {
                fast--;
                continue;
            }
            nums[slow] = nums[fast];
            slow++;
            fast--;
        }
        return fast + 1;
    }

    // 快慢指针2
    public int removeElement3(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (val != nums[fastIndex]) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

    // 暴力解法
    public int removeElement2(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }
}
