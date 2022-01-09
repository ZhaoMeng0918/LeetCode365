package com.gerryZhao;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Array_904水果成篮
 * @Description TODO
 * @Author Administrator
 * @Date 2022-01-05 11:49
 * @Version 1.0.0
 */
public class Array_904水果成篮 {
    /**
     * 这道题可以理解为求只包含两种元素的最长连续子序列
     * 滑动窗口
     */
    public int totalFruit(int[] fruits) {
        int ans = 0, i = 0;
        Counter count = new Counter();
        for (int j = 0; j < fruits.length; j++) {
            count.add(fruits[j], 1);
            while (count.size() >= 3) {
                count.add(fruits[i], -1);
                if (count.get(fruits[i]) == 0) {
                    count.remove(fruits[i]);
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}

class Counter extends HashMap<Integer, Integer> {
    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
    }

    public void add(int k, int v) {
        put(k, get(k) + v);
    }
}