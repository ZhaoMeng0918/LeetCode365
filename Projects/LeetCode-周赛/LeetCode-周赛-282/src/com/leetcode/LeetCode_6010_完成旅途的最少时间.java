package com.leetcode;

import java.util.Arrays;

/**
 * @ClassName LeetCode_6010_完成旅途的最少时间
 * @Description 给你一个数组time，其中time[i]表示第i辆公交车完成一趟旅途所需花费的时间。
 * 每辆公交车可以连续完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以立马开始下一趟旅途。
 * 每辆公交车独立运行，也就是说可以同时有多辆公交车运行且相互不影响。
 * 给你一个整数totalTrips，表示所有公交车总共需要完成的旅途数目。请你返回至少totalTrips趟旅途需要花费的最少时间。
 * 链接：https://leetcode-cn.com/problems/minimum-time-to-complete-trips/
 * @Author Administrator
 * @Date 2022-02-27 10:43
 * @Version 1.0.0
 */
public class LeetCode_6010_完成旅途的最少时间 {
    /**
     * 自己写的垃圾代码
     *
     * @param time
     * @param totalTrips
     * @return
     */
    public static long minimumTime(int[] time, int totalTrips) {
        int[] statistic = new int[time.length];
        Arrays.fill(statistic, 0);
        int tripsCount = 0;
        int timeCount = 1;
        while (tripsCount < totalTrips) {
            for (int i = 0; i < time.length; i++) {
                if (time[i] == 1 || timeCount % time[i] == 0) {
                    statistic[i]++;
                    tripsCount++;
                }
            }
            timeCount++;
        }
        int minTime = 0;
        for (int i = 0; i < statistic.length; i++) {
            minTime = Math.max(minTime, statistic[i] * time[i]);
        }
        return minTime;
    }

    /**
     * 二分法
     *
     * @param time
     * @param totalTrips
     * @return
     */
    public static long minimumTime2(int[] time, int totalTrips) {
        /**
         * 对花费的时间进行二分查找
         * 初始最小时间为0，最大时间为只用一辆速度最快的车跑完所有旅途花费的时间
         * 取中间时间mid，求mid内能完成旅途数目trips
         * 1. 若trips>=totalTrips，表明时间还可以优化，部分车可能跑多了，向左查找right=mid
         * 2. 若trips<totalTrips，表明时间不足，全部车出动了旅途还没跑完，向右查找left=mid+1
         * 坑点：注意返回类型为long
         * 时间复杂度：O(logN)，空间复杂度：O(1)
         */
        // 先将时间排序
        Arrays.sort(time);
        // 计算最长时间：全部旅途都用速度最快的一辆车跑完
        long right = 1L * time[0] * totalTrips;
        long left = 0;
        // 进行二分查找
        while (left < right) {
            long mid = left + ((right - left) >> 1);
            // 计算mid时间能走的旅途次数
            long trips = 0;
            for (int t : time) {
                // 当mid时间不足以完成一趟旅途，接下来的车更不可能，退出
                if (mid < t) {
                    break;
                }
                // 累加每辆车在mid时间内能完成的旅行次数
                trips += mid / t;
            }
            // 判断trips与totalTrips的大小关系进行转移
            if (trips >= totalTrips) {
                // 旅途数超标,时间还可以再优化,向左查找
                right = mid;
            } else {
                // 旅途数不足,时间不足,向右查找
                left = mid + 1;
            }
        }
        // 最后left=right,任意返回一个即可
        return left;
    }
}
