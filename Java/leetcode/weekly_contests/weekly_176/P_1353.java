package leetcode.weekly_contests.weekly_176;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class P_1353 {

    public int maxEvents(int[][] events) {
        final Set<Integer> days = new HashSet<>();
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        for (int[] e : events) {
            for (int i = e[0]; i <= e[1]; i++) {
                if (!days.contains(i)) {
                    days.add(i);
                    break;
                }
            }
        }
        return days.size();
    }
}
