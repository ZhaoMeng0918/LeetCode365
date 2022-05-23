package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_哈希表_438_找到字符串中所有字母异位词 {
    /**
     * 固定窗口去判断
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams_1(String s, String p) {
        int[] record = new int[26];
        for (char ch : p.toCharArray()) {
            record[ch - 'a']++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int[] tmp = Arrays.copyOf(record, record.length);
            for (int j = i; j < i + p.length(); j++) {
                tmp[s.charAt(j) - 'a']--;
            }
            boolean flag = true;
            for (int k = 0; k < tmp.length; k++) {
                if (tmp[k] != 0) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams_2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int lengthS = s.length();
        int lengthP = p.length();
        if (lengthS < lengthP) {
            return list;
        }
        // 制造一个和p一样长的窗口，统计各个字符的数量
        int[] countS = new int[26];
        int[] countP = new int[26];
        for (int i = 0; i < lengthP; i++) {
            countP[p.charAt(i) - 'a']++;
            countS[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(countS, countP)) {
            list.add(0);
        }
        for (int i = lengthP; i < lengthS; i++) {
            countS[s.charAt(i) - 'a']++;
            countS[s.charAt(i - lengthP) - 'a']--;
            if (Arrays.equals(countP, countS)) {
                list.add(i - lengthP + 1);
            }
        }
        return list;
    }

}
