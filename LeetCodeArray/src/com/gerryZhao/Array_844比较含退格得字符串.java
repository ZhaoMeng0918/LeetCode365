package com.gerryZhao;

/**
 * @ClassName Array_844比较含退格得字符串
 * @Description 给定s和t两个字符串，当它们分别被输入到空白得文本编辑器后，请判断二者是否相等。#代表退字符。
 * @Author Administrator
 * @Date 2022-01-04 14:42
 * @Version 1.0.0
 */
public class Array_844比较含退格得字符串 {
    // 双指针
    // 代码写的有问题
    public static boolean backspaceCompare(String s, String t) {
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (sIndex + 1 < s.length() && s.charAt(sIndex + 1) == '#') {
                sIndex += 2;
                continue;
            }
            if (tIndex + 1 < t.length() && t.charAt(tIndex + 1) == '#') {
                tIndex += 2;
                continue;
            }
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                return false;
            }
        }
        if (sIndex != s.length() || tIndex != t.length()) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }

    /**
     * 方法一：重构字符串
     * 使用栈处理遍历过程，每次我们遍历到一个字符：
     * 如果它是退格符，那么我们将栈顶弹出。
     * 如果是普通字符，那么我们将其压入栈中。
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean backspaceCompare2(String s, String t) {
        return build(s).equals(build(t));
    }

    private static String build(String str) {
        StringBuffer sb = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (ch != '#') sb.append(ch);
            else {
                if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    /**
     * 双指针
     * 一个字符是否会被删掉，只取决于该字符后面得退格符，而与该字符前面的退格符无关。
     * 因此当我们逆序地遍历字符串，就可以立即确定当前字符是否会被删除掉。
     * 具体地：我们定义skip表示当前待删除得字符得数量，每次我们遍历到一个字符：
     * 若该字符为退格符，则我们需要多删除一个普通字符，我们让skip+1
     * 若该字符为普通字符：
     * 若skip为0，则说明当前字符不需要删除
     * 若skip不为0，则说明当前字符需要删去，我们让skip-1
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean backspaceCompare3(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j>= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
