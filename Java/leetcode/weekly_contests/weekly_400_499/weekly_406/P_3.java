package leetcode.weekly_contests.weekly_400_499.weekly_406;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_3 {

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        long l = 1;
        long r = 1;
        final PriorityQueue<Integer> h = new PriorityQueue<>(Comparator.reverseOrder());
        final PriorityQueue<Integer> v = new PriorityQueue<>(Comparator.reverseOrder());
        for (int u : horizontalCut) {
            h.add(u);
        }
        for (int u : verticalCut) {
            v.add(u);
        }
        long res = 0;
        while (!h.isEmpty() || !v.isEmpty()) {
            final long ll = l * f(h);
            final long rr = r * f(v);
            if (f(h) > f(v)) {
                r++;
                h.remove();
                res += ll;
            } else {
                l++;
                v.remove();
                res += rr;
            }
        }
        return (int) res;
    }

    private static int f(PriorityQueue<Integer> h) {
        return h.isEmpty() ? 0 : h.peek();
    }
}
