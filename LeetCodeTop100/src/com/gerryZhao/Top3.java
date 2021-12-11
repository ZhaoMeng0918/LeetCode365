package com.gerryZhao;

import java.util.*;

/**
 * @ClassName Top3
 * @Description 无重复字符的最长子串
 * @Author Administrator
 * @Date 2021-11-24 16:19
 * @Version 1.0.0
 */
public class Top3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abba"));
    }

    // 暴力法
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        Set<Character> tmpSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            tmpSet.clear();
            int tmpCount = 0;
            for (int j = i; j < s.length(); j++) {
                if (tmpSet.contains(s.charAt(j))) {
                    break;
                } else {
                    tmpSet.add(s.charAt(j));
                    tmpCount++;
                }
            }
            res = Math.max(res, tmpCount);
        }

        return res;
    }

    // 快慢指针
    // 本来计划是从O(n^2)变到O(n)，但是中间使用了Map，移除时又增加了一层循环
    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        int tmpCount = 0;
        int low = 0, high = 0;
        Map<Character, Integer> tmpMap = new HashMap<>();
        while (high < s.length()) {
            if (tmpMap.containsKey(s.charAt(high))) {
                int index = tmpMap.get(s.charAt(high));
                tmpCount = tmpCount - (index - low);
                low = index + 1;
                tmpMap.replace(s.charAt(high), high);
                // 这里要清除low之前存入的数据
                Iterator<Map.Entry<Character, Integer>> entries = tmpMap.entrySet().iterator();
                while (entries.hasNext()) {
                    Map.Entry<Character, Integer> entry = entries.next();
                    if (entry.getValue() < low) {
                        entries.remove();
                    }
                }
            } else {
                tmpMap.put(s.charAt(high), high);
                tmpCount++;
            }
            high++;
            res = Math.max(res, tmpCount);
        }
        return res;
    }

    // 滑动窗口
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        // a b c a b c d a d e
        // 0 1 2 3 4 5 6 7 8 9
        int maxSize = 0;
        // 记录ASCII码字符出现的位置，以字符作为下标
        int[] dict = new int[128];
        // 为了方便理解，这里把数组内容全部设为 -1，之后在记录的时候就可以从 0 开始，方便理解
        Arrays.fill(dict, -1);
        // 用于记录重复 ASCII 码字符出现的位置的值
        int repeatValue = -1;
        // 当前下标
        int i = 0;
        int ASCII;
        while (i < s.length()) {
            ASCII = s.charAt(i);
            // 如果当前位置的值 > repeatValue，证明当前位置已经赋过一次值了，证明字符重复
            if (dict[ASCII] > repeatValue) {
                // 更新 repeatValue 为之前赋值的下标
                repeatValue = dict[ASCII];
            }
            // 将当前下标赋值到数组相应位置
            dict[ASCII] = i;
            // i - repeatValue(去除重复部分)
            // 比如 abcabcdade 中的三个 a 的计算  abca - a(3 - 0)=bca   abcabcda - abca(7 - 3)=bcda
            maxSize = Math.max(maxSize, i - repeatValue);
            // s.length() - repeatValue - 1 判断剩下的数有没有必要继续循环
            // 比如 abcabcdade 最后的 a(当 i = 7 repeatValue = 3) ，abcabcdade - abca(10-3-1) = bcdade  剩下最多有六位
            // 比如 abcabcdade 最后的 d(当 i = 8 repeatValue = 6) ，abcabcdade - abcabcd(10-6-1) = ade  剩下最多也是三位
            if (maxSize >= s.length() - repeatValue - 1) {
                return maxSize;
            }
            i++;
        }
        return maxSize;
    }
}
