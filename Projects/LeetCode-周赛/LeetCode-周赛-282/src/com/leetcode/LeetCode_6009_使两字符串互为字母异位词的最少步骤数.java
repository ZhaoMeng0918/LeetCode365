package com.leetcode;

import java.util.HashMap;

/**
 * @ClassName LeetCode_6009_使两字符串互为字母异位词的最少步骤数
 * @Description 给你两个字符串s和t，在一步操作中，你可以给s或者t追加任一字符。
 * 返回使s和t互为字母异位词所需的最少步骤数。
 * 字母异位词 指字母相同但是顺序不同（或者相同）的字符串。
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/
 * @Author Administrator
 * @Date 2022-02-27 10:42
 * @Version 1.0.0
 */
public class LeetCode_6009_使两字符串互为字母异位词的最少步骤数 {
    /**
     * 分别统计两个字符串的字符个数，用HashMap进行存储。
     * 以S字符串为主，遍历过程中：
     * 若S中某个字符的个数大于T的，进行countS - countT统计；
     * 若S中某个字符的个数小于T的，进行countT - countS统计；
     * 这样以S为主，所有相差的字符都统计完成。
     * <p>
     * 再以T字符串为主，此时仅考虑T中有而S中没有的字符个数即可。
     *
     * @param s
     * @param t
     * @return
     */
    public static int minSteps1(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int res = 0;
        for (char keyS : mapS.keySet()) {
            int countS = mapS.getOrDefault(keyS, 0);
            int countT = mapT.getOrDefault(keyS, 0);
            if (countT > countS) {
                res += (countT - countS);
            } else {
                res += (countS - countT);
            }
        }
        for (char keyT : mapT.keySet()) {
            if (mapS.get(keyT) == null) {
                int countT = mapT.getOrDefault(keyT, 0);
                res += countT;
            }
        }
        return res;
    }

    /**
     * 统计公共部分有多少个,两个字符串公共部分之外的数目之和就是操作次数
     *
     * @param s
     * @param t
     * @return
     */
    public static int minSteps2(String s, String t) {
        int[] arr = new int[26];
        // 遍历两个字符串,假定s的字母为正,t的字母为负数
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[s.charAt(i) - 'a']--;
        }
        int cnt = 0;
        for (int num : arr) {
            cnt += Math.abs(num);
        }
        return cnt;
    }
}
