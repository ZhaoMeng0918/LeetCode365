package com.gerryZhao;

/**
 * @ClassName Array_704二分查找
 * @Description TODO
 * @Author Administrator
 * @Date 2022-01-03 14:04
 * @Version 1.0.0
 */
public class Array_704二分查找 {
    /**
     * 关键词：有序数组、无重复元素 ----> 二分查找
     */

    /**
     * 自己写的代码
     *执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了8.63%的用户
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    /**
     * 二分法第一种写法：
     * 我们定义target是在一个左闭右闭的区间里，也就是[left, right]
     * 区间的定义就决定了二分法的代码应该如何写，因为定义target在[left, right]区间，所以有如下两点：
     * while(left <= right) 要使用<=，因为left == right是有意义的，所以使用<=。
     * if(nums[middle] > target) right = middle - 1，因为当前这个nums[middle]一定不是target，那么接下来要查找的左区间结束下标位置就是middle-1。
     *
     * 二分法第二种写法：
     * 如果说定义target是在一个左闭右开的区间里，也就是[left, right)，那么二分法的边界处理方式则截然不同。
     * while(left < right)，这里使用<，因为left == right在区间[left, right)是没有意义的。
     * if(nums[middle] > target) right = middle，因为当前nums[middle]不等于middle，去左区间继续寻找，而寻找区间是左闭右开区间，所以right更新为middle。
     */
    // 版本一 左闭右闭
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0] || nums[nums.length - 1] < target) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;
        }
        return -1;
    }

    // 版本二 左闭右开
    public int search3(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0] || nums[nums.length - 1] < target) return -1;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid;
            else return mid;
        }
        return -1;
    }
}
