package leetcode.biweekly_contests.biweekly_69;

import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public int longestPalindrome(String[] words) {
        final Map<String, Integer> f = new HashMap<>();
        for (String w : words) {
            f.merge(w, 1, Integer::sum);
        }
        int res = 0;
        for (String w : words) {
            final String rev = new StringBuilder(w).reverse().toString();
            if (rev.equals(w)) {
                int count = f.get(w);
                if (count % 2 != 0) {
                    count--;
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
        for (String w : words) {
            if (w.charAt(0) == w.charAt(1)) {
                final int count = f.get(w);
                if (count == 1) {
                    res++;
                    break;
                }
            }
        }
        return 2 * res;
    }
}
