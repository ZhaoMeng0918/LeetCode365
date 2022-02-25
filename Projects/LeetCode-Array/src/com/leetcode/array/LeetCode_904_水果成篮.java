package com.leetcode.array;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName LeetCode_904_水果成篮
 * @Description TODO
 * @Author Administrator
 * @Date 2022-02-25 9:33
 * @Version 1.0.0
 */
public class LeetCode_904_水果成篮 {
    /**
     * Map
     *
     * @param fruits
     * @return
     */
    public int totalFruit1(int[] fruits) {
        if (fruits == null) return 0;
        if (fruits.length <= 2) return fruits.length;
        int res = 0;
        Map<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], null);
            for (int j = i + 1; j < fruits.length; j++) {
                map.put(fruits[j], null);
                if (map.size() <= 2) {
                    res = Math.max(res, j - i + 1);
                } else {
                    map.clear();
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 滑动窗口
     *
     * @param fruits
     * @return
     */
    public int totalFruit2(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> window = new HashMap<>();
        int L = 0;
        int R = 0;
        int max = 0;
        while (R < n) {
            int addWindow = fruits[R];
            R++;
            if (window.size() <= 2) {
                window.put(addWindow, window.getOrDefault(addWindow, 0) + 1);
            }
            while (window.size() > 2) {
                int subWindow = fruits[L];
                L++;
                if (window.containsKey(subWindow)) {
                    window.put(subWindow, window.getOrDefault(subWindow, 0) - 1);
                    if (window.get(subWindow) <= 0) {
                        window.remove(subWindow);
                    }
                }
            }
            max = Math.max(max, R - L);
        }
        return max;
    }

    /**
     * 右指针一直向右滑动，关键在于左指针怎么变化，当水果数超过2时，记录下当前长度，然后左指针开始变化。
     * 左指针变化的目标是让当前水果种类维持两个，而右指针和左指针左边那个正好已经是两个不同了，
     * 那么左指针变化就是从右指针前一个开始，找到第一个不同的截至。
     * 话到最后就输出curr，要是curr没被更新，就输出fruits长度。
     *
     * @param fruits
     * @return
     */
    public int totalFruit3(int[] fruits) {
        if (fruits == null) return 0;
        if (fruits.length <= 2) return fruits.length;
        int left = 0;
        int right = 1;
        int curr = 0;
        HashMap<Integer, Object> map = new HashMap<>();
        map.put(fruits[0], null);
        while (right < fruits.length) {
            if (fruits[right] != fruits[right - 1] && map.get(fruits[right]) == null) {
                map.put(fruits[right], null);
                if (map.size() > 2) {
                    curr = Math.max(curr, right - 1);
                    left = right - 1;
                    while (fruits[left] == fruits[left - 1]) {
                        left--;
                    }
                    map.clear();
                    map.put(fruits[left], null);
                    map.put(fruits[right], null);
                }
            }
            right++;
        }
        return Math.max(curr, right - 1);
    }
}
