package com.leetcode.hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode_202_快乐数
 * @Description 编写一个算法来判断一个数n是不是快乐数。
 * 快乐数定义：
 * 1. 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 2. 然后重复这个过程直到这个数变为1，也可能是无限循环但始终变不到1。
 * 3. 如果这个过程结果为1，那么这个数就是快乐数。
 * @Author Administrator
 * @Date 2022-02-28 10:04
 * @Version 1.0.0
 */
public class LeetCode_202_快乐数 {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

    public boolean isHappy2(int n) {
        Set<Integer> record = new HashSet<>();
        while (n > 1) {
            if (record.contains(n)) return false;
            record.add(n);
            int count = 0;
            while (n > 0) {
                int temp = n % 10;
                count += temp * temp;
                n /= 10;
            }
            n = count;
        }
        return true;
    }
}
