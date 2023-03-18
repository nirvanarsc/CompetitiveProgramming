package leetcode.biweekly_contests.biweekly_0_99.biweekly_69;

import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public int longestPalindrome(String[] words) {
        final Map<String, Integer> f = new HashMap<>();
        for (String w : words) {
            f.merge(w, 1, Integer::sum);
        }
        int res = 0;
        int odd = 0;
        for (String w : words) {
            final String rev = w.charAt(1) + String.valueOf(w.charAt(0));
            if (rev.equals(w)) {
                int count = f.get(w);
                if (count % 2 != 0) {
                    count--;
                    odd = 1;
                }
                f.merge(w, -count, Integer::sum);
                res += count;
            } else {
                final int take = Math.min(f.get(w), f.getOrDefault(rev, 0));
                f.merge(w, -take, Integer::sum);
                f.merge(rev, -take, Integer::sum);
                res += 2 * take;
            }
        }
        return 2 * (res + odd);
    }
}
