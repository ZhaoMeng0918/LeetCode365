package com.leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode_454_四数相加
 * @Description 给你四个整数数组，数组长度都是n，请你计算有多少个元组(i, j, k, 1)能满足：
 * 1. 0 <= i, j, k, l < n
 * 2. nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * @Author Administrator
 * @Date 2022-02-28 10:37
 * @Version 1.0.0
 */
public class LeetCode_454_四数相加 {
    /**
     * 两个循环快于四个循环
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int res = 0;
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (map.containsKey(0 - temp)) {
                    res += map.get(0 - temp);
                }
            }
        }
        return res;
    }
}
