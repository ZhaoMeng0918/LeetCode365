package com.leetcode;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.*;

public class LeetCode_数组_904_水果成篮 {
    /**
     * 暴力破解
     *
     * @param fruits
     * @return
     */
    public int totalFruit_1(int[] fruits) {
        int result = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        HashSet<Integer> types = new HashSet<>();
        int count = 0;
        for (i = 0; i < fruits.length && j != fruits.length; i++) {
            count = 0;
            types.clear();
            for (j = i; j < fruits.length; j++) {
                if (types.size() < 2 || types.contains(fruits[j])) {
                    types.add(fruits[j]);
                    count++;
                } else {
                    result = Math.max(result, count);
                    break;
                }

            }
        }
        return Math.max(result, count);
    }

    /**
     * 滑动窗口
     *
     * @param fruits
     * @return
     */
    public int totalFruit_2(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
