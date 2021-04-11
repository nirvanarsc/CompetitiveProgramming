package leetcode.weekly_contests.weekly_236;

import java.util.TreeSet;

public class P_1823 {

    public int findTheWinner(int n, int k) {
        final TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            ts.add(i);
        }
        int curr = 1;
        while (ts.size() > 1) {
            for (int i = 1; i < k; i++) {
                final Integer next = ts.higher(curr);
                if (next == null) {
                    curr = ts.first();
                } else {
                    curr = next;
                }
            }
            final Integer next = ts.higher(curr);
            ts.remove(curr);
            if (next == null) {
                curr = ts.first();
            } else {
                curr = next;
            }
        }
        return ts.first();
    }

}
