package leetcode.weekly_contests.weekly_81;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P_822 {

    public int flipgame(int[] fronts, int[] backs) {
        final PriorityQueue<Integer> valid = new PriorityQueue<>();
        final Set<Integer> banned = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                banned.add(fronts[i]);
            } else {
                valid.add(fronts[i]);
                valid.add(backs[i]);
            }
        }
        while (!valid.isEmpty()) {
            final Integer curr = valid.remove();
            if (!banned.contains(curr)) {
                return curr;
            }
        }
        return 0;
    }
}
