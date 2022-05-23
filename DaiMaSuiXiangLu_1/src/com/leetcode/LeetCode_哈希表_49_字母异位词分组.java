package com.leetcode;

import java.util.*;

public class LeetCode_哈希表_49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);// 排序
            String key = String.valueOf(ch); // 唯一的key，就可以进行判断啦
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
