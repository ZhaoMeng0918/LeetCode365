package com.gerryZhao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Backtracking_切割问题_93复原IP地址
 * @Description 给定一个只包含数字的字符串，复原它并返回所有可能的IP地址格式。
 * 有效的IP地址正好由四个整数（每个整数位于0到255之间组成，且不能含有前导0），整数之间用'.'分隔。
 * @Author Administrator
 * @Date 2021-12-07 14:22
 * @Version 1.0.0
 */
public class Backtracking_切割问题_93复原IP地址 {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresss(String s) {
        if (s.length() > 12) return result;
        backTracking(s, 0, 0);
        return result;
    }

    private void backTracking(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) result.add(s);
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backTracking(s, i + 2, pointNum);
                pointNum--;
                s = s.substring(0, i+1) + s.substring(i+2);
            } else break;
        }
    }

    private Boolean isValid(String s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') return false;
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) return false;
        }
        return true;
    }
}
