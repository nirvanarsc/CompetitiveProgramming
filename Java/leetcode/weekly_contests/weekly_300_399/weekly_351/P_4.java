package leetcode.weekly_contests.weekly_300_399.weekly_351;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class P_4 {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        final int n = positions.length;
        final int[][] sorted = new int[n][3];
        for (int i = 0; i < n; i++) {
            sorted[i] = new int[] { positions[i], healths[i], directions.charAt(i) == 'L' ? -1 : 1, i };
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        final Deque<int[]> dq = new ArrayDeque<>();
        final List<int[]> res = new ArrayList<>();
        for (int[] r : sorted) {
            if (r[2] == -1) {
                while (true) {
                    if (dq.isEmpty()) {
                        res.add(r);
                        break;
                    }
                    final int[] pop = dq.removeFirst();
                    if (pop[1] > r[1]) {
                        pop[1]--;
                        dq.addFirst(pop);
                        break;
                    } else if (pop[1] < r[1]) {
                        r[1]--;
                        continue;
                    } else {
                        break;
                    }
                }
            } else {
                dq.addFirst(r);
            }
        }
        res.addAll(dq);
        return res.stream()
                  .sorted(Comparator.comparingInt(a -> a[3]))
                  .map(v -> v[1])
                  .collect(Collectors.toList());
    }
}
