package leetcode.weekly_contests.weekly_82;

import java.util.HashMap;
import java.util.Map;

public class P_825 {

    public int numFriendRequests(int[] ages) {
        final int[] map = new int[121];
        for (int age : ages) {
            map[age]++;
        }
        for (int i = 1; i < map.length; i++) {
            map[i] += map[i - 1];
        }
        int res = 0;
        for (int age : ages) {
            res += Math.max(0, map[age] - map[(age / 2) + 7] - 1);
        }
        return res;
    }

    public int numFriendRequestsMap(int[] ages) {
        final Map<Integer, Integer> count = new HashMap<>();
        for (int age : ages) {
            count.merge(age, 1, Integer::sum);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> a : count.entrySet()) {
            for (Map.Entry<Integer, Integer> b : count.entrySet()) {
                if (request(a.getKey(), b.getKey())) {
                    res += a.getValue() * (b.getValue() - (a.getKey().equals(b.getKey()) ? 1 : 0));
                }
            }
        }
        return res;
    }

    private static boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a);
    }
}
