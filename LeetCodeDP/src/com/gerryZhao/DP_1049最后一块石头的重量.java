package com.gerryZhao;

import java.util.Arrays;

/**
 * @ClassName DP_1049最后一块石头的重量
 * @Description 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出任意两块石头，然后将他们一起粉碎。假设石头的重量分别为x和y，且x <= y。
 * 那么粉碎的可能结果如下：
 * 如果x == y，那么两块石头都会完全粉碎；
 * 如果x != y，那么重量为x的石头将会被完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块石头。
 * 返回此石头最小的可能重量。如果没有石头剩下，就返回0。
 * @Author Administrator
 * @Date 2021-12-03 14:34
 * @Version 1.0.0
 */
public class DP_1049最后一块石头的重量 {
    public static void main(String[] args) {
        int[] stones = new int[]{31, 26, 33, 21, 40};
        System.out.println(lastStoneWeightII(stones));
    }

    /**
     * 暴力解法
     * 备注: 必须将数组划分为差值最小的两块
     *
     */
    public static int lastStoneWeightII(int[] stones) {
        int flag = 0;
        int index = -1;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] != 0) {
                flag++;
                index = i;
            }
            if (flag >= 2) {
                break;
            }
        }
        if (flag == 1) {
            return stones[index];
        }

        // 先排个序
        Arrays.sort(stones);
        for (int i = 0; i < stones.length - 1; ) {
            if (stones[i] == 0) {
                i++;
                continue;
            }
            int tmp = stones[i + 1] - stones[i];
            stones[i++] = 0;
            stones[i++] = tmp;
        }

        return lastStoneWeightII(stones);
    }


    /**
     * 本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小。这样就化解成01背包问题了。
     * stones[i]: 物品的重量
     * stones[i]: 物品的价值
     * 动规五步曲：
     * 1. 确定dp数组以及下标的含义
     * dp[j]: 表示容量为j的背包，最多可以背dp[j]这么重的石头。
     * 2. 确定递推公式
     * dp[j] = max(dp[j], dp[j - stones[i]] + stones[i])
     * 3. dp数组如何初始化
     * 既然dp[j]中的j表示容量，那么最大容量是多少呢？ -- 就是所有石头的重量和。
     * 因为提示中给出 1 <= stones.length <= 30, 1 <= stones[i] <= 1000, 所以最大重量就是30 * 1000。
     * 而我们要求的target其实只是最大重量的一半，所以dp数组开到15000大小就可以了。
     * 当然也可以把石头遍历一遍，计算出石头总重量然后除以2，得到dp数组的大小。
     * 初始化dp[j]，因为重量都不会是负数，所以dp[j]都初始化为0就可以了，
     * 这样在递归式dp[j]=max(dp[j], dp[j-stones[i]] + stones[i])
     * 4. 确定遍历顺序
     * 如果使用一维数组，物品遍历的for循环放在外层，遍历背包的for循环放在内层，且内层for循环倒叙遍历。
     * 5. 举例推导dp数组
     *
     */
}
