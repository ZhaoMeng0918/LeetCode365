package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_哈希表_350_两个数组的交集II {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        Object[] keys = map1.keySet().toArray();
        int[] result = new int[nums1.length];
        int length = 0;
        for (int i = 0; i < keys.length; i++) {
            if (map1.get(keys[i]) == 0 || map2.getOrDefault(keys[i], 0) == 0) {
                continue;
            }
            for (int j = 0; j < (map1.get(keys[i]) < map2.get(keys[i]) ? map1.get(keys[i]) : map2.get(keys[i])); j++) {
                result[length++] = (int) keys[i];
            }
        }
        return Arrays.copyOf(result, length);
    }
}
