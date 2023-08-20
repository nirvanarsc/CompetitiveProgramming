package leetcode.weekly_contests.weekly_300_399.weekly_359;

import java.util.HashSet;
import java.util.Set;

public class P_2 {

    public int minimumSum(int n, int k) {
        int res = 0;
        final Set<Integer> set = new HashSet<>();
        int curr = 1;
        while (set.size() < n) {
            while (set.contains(k - curr)) {
                curr++;
            }
            set.add(curr);
            res += curr;
            curr++;
        }
        return res;
    }
}
