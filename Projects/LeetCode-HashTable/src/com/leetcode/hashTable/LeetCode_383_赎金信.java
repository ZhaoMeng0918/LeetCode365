package com.leetcode.hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName LeetCode_383_赎金信
 * @Description 给你两个字符串，ransomNote和magazine，判断ransomNote能不能由magazine里面的字符构成。
 * magazine中的每个字符只能用一次。
 * 你可以假设两个字符串均只含有小写字母。
 * @Author Administrator
 * @Date 2022-03-01 10:06
 * @Version 1.0.0
 */
public class LeetCode_383_赎金信 {
    /**
     * 哈希表
     *
     * 执行用时： 18 ms, 在所有 Java 提交中击败了5.34%的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了5.06%的用户
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct1(String ransomNote, String magazine) {
        Map<Character, Integer> record = new HashMap<>();
        for (char chr : ransomNote.toCharArray()) {
            record.put(chr, record.getOrDefault(chr, 0) + 1);
        }
        for (char chr : magazine.toCharArray()) {
            if (record.containsKey(chr)) {
                record.put(chr, record.getOrDefault(chr, 0) - 1);
            }
        }
        for (char chr : record.keySet()) {
            if (record.get(chr) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 本题情况下，使用map的空间消耗要比数组大一些，因为map要维护红黑树或者哈希表，而且还要做哈希函数。
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] record = new int[26];
        Arrays.fill(record, 0);
        for (char chr : magazine.toCharArray()) {
            record[chr - 'a']++;
        }
        for (char chr : ransomNote.toCharArray()) {
            record[chr - 'a']--;
            if (record[chr - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
