package leetcode.weekly_contests.weekly_300_399.weekly_325;

import java.util.TreeSet;

public class P_3 {

    public int maximumTastiness(int[] price, int k) {
        final TreeSet<Integer> ts = new TreeSet<>();
        for (int p : price) {
            ts.add(p);
        }
        int lo = 1;
        int hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            int count = 1;
            Integer curr = ts.first();
            while (curr != null) {
                curr = ts.ceiling(curr + mid);
                if (curr != null) {
                    count++;
                }
            }
            if (count < k) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return ts.size() < k ? 0 : lo;
    }
}
