package com.gerryZhao;

import java.util.*;

/**
 * @ClassName Backtracking_深度搜索_332重新安排行程
 * @Description 给定一个机票的字符串二维数组[from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
 * 所有这些机票都属于一个从JFK出发的先生，所以该行程必须从JFK开始。
 * 提示：
 * 如果存在多种有效行程，请你按照字符自然排序返回最小的行程组合。
 * 所有的机场都用三个大写字母表示。
 * 假定所有机票都至少存在一种合理的行程。
 * 所有的机票必须都用一次且只能用一次。
 * @Author Administrator
 * @Date 2021-12-09 14:17
 * @Version 1.0.0
 */
public class Backtracking_深度搜索_332重新安排行程 {
    /**
     * 图论的深度优先搜索，中间使用了回溯
     * 难点：
     * 1. 一个行程中，如果航班处理不好容易变成一个圈，成为死循环。
     * 2. 有多种解法，字母序靠前排在前面，让很多同学望而退步，该如何记录映射关系呢？
     * 3. 使用回溯法，终止条件是什么？
     * 4. 搜索过程中，如何遍历一个机场所对应的所有机场
     */

    private Deque<String> res = new LinkedList<>();
    private Map<String, Map<String, Integer>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> t : tickets) {
            Map<String, Integer> tmp;
            // 航班次数
            if (map.containsKey(t.get(0))) {
                tmp = map.get(t.get(0));
                tmp.put(t.get(1), tmp.getOrDefault(t.get(1), 0) + 1);
            } else {
                tmp = new TreeMap<>(); // 升序Map
                tmp.put(t.get(1), 1);
            }
            map.put(t.get(0), tmp);
        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    private boolean backTracking(int ticketNum) {
        if (res.size() == ticketNum + 1) return true;
        String last = res.getLast();
        if (map.containsKey(last)) {
            for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
                int count = target.getValue();
                if (count > 0) {
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if (backTracking(ticketNum)) return true;
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }
}
