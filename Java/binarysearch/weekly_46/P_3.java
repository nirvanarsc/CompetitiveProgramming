package binarysearch.weekly_46;

import java.util.PriorityQueue;

@SuppressWarnings("ComparatorCombinators")
public class P_3 {

    public int solve(int[][] orders) {
        final PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        final PriorityQueue<int[]> sell = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        for (int[] o : orders) {
            if (o[2] == 0) {
                while (!sell.isEmpty() && sell.element()[0] <= o[0]) {
                    final int[] curr = sell.remove();
                    final int use = Math.min(curr[1], o[1]);
                    curr[1] -= use;
                    o[1] -= use;
                    res += use;
                    if (curr[1] > 0) {
                        sell.add(curr);
                        break;
                    }
                }
                if (o[1] > 0) {
                    buy.add(o);
                }
            } else {
                while (!buy.isEmpty() && buy.element()[0] >= o[0]) {
                    final int[] curr = buy.remove();
                    final int use = Math.min(curr[1], o[1]);
                    curr[1] -= use;
                    o[1] -= use;
                    res += use;
                    if (curr[1] > 0) {
                        buy.add(curr);
                        break;
                    }
                }
                if (o[1] > 0) {
                    sell.add(o);
                }
            }
        }
        return res;
    }
}
