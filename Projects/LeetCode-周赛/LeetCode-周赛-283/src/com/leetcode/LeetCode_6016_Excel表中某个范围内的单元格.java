package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode_6016_Excel表中某个范围内的单元格
 * @Description TODO
 * @Author Administrator
 * @Date 2022-03-07 9:22
 * @Version 1.0.0
 */
public class LeetCode_6016_Excel表中某个范围内的单元格 {
    public List<String> cellsInRange(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        char col_1 = s.charAt(0);
        int row_1 = s.charAt(1) - '0';
        char col_2 = s.charAt(3);
        int row_2 = s.charAt(4) - '0';
        for (int i = col_1; i <= col_2; i++) {
            for (int j = row_1; j <= row_2; j++) {
                res.add((char)i + "" + j);
            }
        }
        return res;
    }
}
