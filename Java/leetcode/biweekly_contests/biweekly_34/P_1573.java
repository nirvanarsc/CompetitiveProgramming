package leetcode.biweekly_contests.biweekly_34;

import java.util.HashMap;
import java.util.Map;

public class P_1573 {

    private static final int MOD = (int) (1e9 + 7);

    public int numWays(String s) {
        int ones = 0, idx = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
                map.put(++idx, i);
            }
        }
        if (ones % 3 != 0) {
            return 0;
        }
        if (ones == 0) {
            final long n = s.length() - 2;
            return (int) ((n * (n + 1) / 2) % MOD);
        }
        final int target = ones / 3;
        final long left = map.get(target + 1) - map.get(target);
        final long right = map.get(target * 2 + 1) - map.get(2 * target);
        return (int) ((left * right) % MOD);
    }
}
