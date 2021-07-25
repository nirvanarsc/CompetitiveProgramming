package leetcode.biweekly_contests.biweekly_57;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P_2 {

    public int smallestChair(int[][] times, int targetFriend) {
        final TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < (int) 2e4; i++) {
            ts.add(i);
        }
        final int n = times.length;
        final int[][] indexed = new int[2 * n][3];
        int j = 0;
        for (int i = 0; i < n; i++) {
            indexed[j++] = new int[] { times[i][0], -1, i };
            indexed[j++] = new int[] { times[i][1], 1, i };
        }
        Arrays.sort(indexed, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1])
                                                    : Integer.compare(a[0], b[0]));
        final Map<Integer, Integer> occupied = new HashMap<>();
        for (int[] curr : indexed) {
            if (curr[1] == -1) {
                //noinspection ConstantConditions
                final int taken = ts.pollFirst();
                occupied.put(curr[2], taken);
                if (curr[2] == targetFriend) {
                    return taken;
                }
            } else {
                ts.add(occupied.get(curr[2]));
            }
        }
        return -1;
    }
}
