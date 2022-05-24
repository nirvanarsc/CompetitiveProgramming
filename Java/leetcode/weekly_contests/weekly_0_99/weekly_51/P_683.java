package leetcode.weekly_contests.weekly_0_99.weekly_51;

import java.util.TreeSet;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_683 {

    public int kEmptySlotsBST(int[] bulbs, int K) {
        final TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < bulbs.length; i++) {
            set.add(bulbs[i]);
            final Integer lower = set.lower(bulbs[i]);
            if (lower != null && bulbs[i] - lower - 1 == K) {
                return i + 1;
            }
            final Integer higher = set.higher(bulbs[i]);
            if (higher != null && higher - bulbs[i] - 1 == K) {
                return i + 1;
            }
        }
        return -1;
    }

    public int kEmptySlots(int[] bulbs, int K) {
        final int[] days = new int[bulbs.length];
        for (int i = 0; i < bulbs.length; i++) {
            days[bulbs[i] - 1] = i + 1;
        }
        int left = 0, right = K + 1, res = Integer.MAX_VALUE;
        for (int i = 0; right < days.length; i++) {
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (i == right) {
                    res = Math.min(res, Math.max(days[left], days[right]));
                }
                left = i;
                right = K + 1 + i;
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}
