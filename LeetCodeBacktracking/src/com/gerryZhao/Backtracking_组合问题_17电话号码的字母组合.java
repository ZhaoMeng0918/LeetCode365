package com.gerryZhao;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Bactracking_17电话号码的字母组合
 * @Description 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
 * @Author Administrator
 * @Date 2021-12-06 15:19
 * @Version 1.0.0
 */
public class Backtracking_组合问题_17电话号码的字母组合 {
    List<String> list = new ArrayList<>();
    StringBuilder temp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return list;
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return list;
    }

    public void backTracking(String digits, String[] numString, int num) {
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(digits, numString, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
