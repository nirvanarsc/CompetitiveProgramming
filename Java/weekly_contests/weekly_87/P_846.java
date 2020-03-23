package weekly_contests.weekly_87;

import java.util.TreeMap;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_846 {

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        final TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int num : hand) {
            freq.merge(num, 1, Integer::sum);
        }
        while (!freq.isEmpty()) {
            final int min = freq.firstKey();
            for (int curr = min; curr < min + W; curr++) {
                if (!freq.containsKey(curr)) {
                    return false;
                }
                compute(freq, curr);
            }
        }
        return true;
    }

    private static void compute(TreeMap<Integer, Integer> freq, int first) {
        freq.merge(first, -1, Integer::sum);
        if (freq.get(first) == 0) {
            freq.remove(first);
        }
    }
}
