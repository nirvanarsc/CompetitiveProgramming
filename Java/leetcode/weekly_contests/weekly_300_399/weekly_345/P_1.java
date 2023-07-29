package leetcode.weekly_contests.weekly_300_399.weekly_345;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public int[] circularGameLosers(int n, int k) {
        final boolean[] seen = new boolean[n];
        int curr = 0;
        for (int u = 1; !seen[curr]; u++) {
            seen[curr] = true;
            curr = (curr + u * k) % n;
        }
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                res.add(i + 1);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
