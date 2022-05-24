package leetcode.weekly_contests.weekly_200_299.weekly_233;

import java.util.PriorityQueue;

public class P_1801 {

    private static final int MOD = (int) (1e9 + 7);

    public int getNumberOfBacklogOrders(int[][] orders) {
        final PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        final PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int[] o : orders) {
            if (o[2] == 0) {
                while (!sell.isEmpty() && sell.element()[0] <= o[0]) {
                    final int[] c = sell.remove();
                    final int matched = Math.min(c[1], o[1]);
                    c[1] -= matched;
                    o[1] -= matched;
                    if (c[1] > 0) {
                        sell.offer(c);
                    }
                    if (o[1] == 0) {
                        break;
                    }
                }
                if (o[1] > 0) {
                    buy.add(o);
                }
            } else {
                while (!buy.isEmpty() && buy.element()[0] >= o[0]) {
                    final int[] c = buy.remove();
                    final int matched = Math.min(c[1], o[1]);
                    c[1] -= matched;
                    o[1] -= matched;
                    if (c[1] > 0) {
                        buy.offer(c);
                    }
                    if (o[1] == 0) {
                        break;
                    }
                }
                if (o[1] > 0) {
                    sell.add(o);
                }
            }
        }

        int res = 0;
        while (!sell.isEmpty()) {
            res = (res + sell.remove()[1]) % MOD;
        }
        while (!buy.isEmpty()) {
            res = (res + buy.remove()[1]) % MOD;
        }
        return res;
    }
}
