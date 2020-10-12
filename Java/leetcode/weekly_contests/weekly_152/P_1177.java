package leetcode.weekly_contests.weekly_152;

import java.util.ArrayList;
import java.util.List;

public class P_1177 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        final int[] prefixMap = new int[s.length()];
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            mask ^= 1 << (s.charAt(i) - 'a');
            prefixMap[i] = mask;
        }

        final List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            res.add(check(prefixMap, q[0], q[1], q[2]));
        }
        return res;
    }

    private static boolean check(int[] map, int from, int to, int k) {
        final int mask = map[to] ^ (from > 0 ? map[from - 1] : 0);
        final int odds = Integer.bitCount(mask);
        return odds <= 1 || odds / 2 <= k;
    }
}
