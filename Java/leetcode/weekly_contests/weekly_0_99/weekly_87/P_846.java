package leetcode.weekly_contests.weekly_0_99.weekly_87;

import java.util.TreeMap;

public class P_846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        final TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int num : hand) {
            freq.merge(num, 1, Integer::sum);
        }
        while (!freq.isEmpty()) {
            final int first = freq.firstKey();
            for (int u = first; u < first + groupSize; u++) {
                if (!freq.containsKey(u)) {
                    return false;
                }
                if (freq.merge(u, -1, Integer::sum) == 0) {
                    freq.remove(u);
                }
            }
        }
        return true;
    }
}
