package com.leetcode.hashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode_349_两个数组的交集
 * @Description 给定两个数组nums1和nums2，返回它们的交集。输出结果中的每个元素一定是唯一的。我们可以不考虑输出结果的顺序。
 * @Author Administrator
 * @Date 2022-02-28 9:44
 * @Version 1.0.0
 */
public class LeetCode_349_两个数组的交集 {
    /**
     * 注意：使用数组来做哈希的题目，是因为题目都限制了数值的大小。
     * 而这道题没有限制数值的大小，就无法使用数组来做哈希表了。
     *
     * 而且如果哈希值比较少、特别分散、跨度非常大，使用数组就造成空间的极大浪费。
     *
     * 注意：直接使用set不仅占用空间比数组大，而且速度要比数组慢，set把数值映射到key上都要做hash计算的。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        // Set.add()：如果集合已经包含了相同的对象，则不改变Set集合。
        for (int i : nums1) set.add(i);
        for (int i : nums2) {
            if (set.contains(i)) {
                resSet.add(i);
            }
        }
        int[] resArr = new int[resSet.size()];
        int index = 0;
        for (int i : resSet) resArr[index++] = i;
        return resArr;
    }
}
