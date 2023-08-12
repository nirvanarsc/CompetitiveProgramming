package leetcode.biweekly_contests.biweekly_100_199.biweekly_108;

import java.util.HashSet;
import java.util.Set;

public class P_3 {

    static Set<Integer> pow5;

    public int minimumBeautifulSubstrings(String s) {
        final int n = s.length();
        int res = (int) 1e9;
        pow5 = new HashSet<>();
        int p = 1;
        for (int i = 0; i < 10; i++) {
            pow5.add(p);
            p *= 5;
        }
        for (int mask = 0; mask < 1 << (n - 1); mask++) {
            res = Math.min(res, f(s, mask, n));
        }
        return res == (int) 1e9 ? -1 : res;
    }

    private static int f(String s, int mask, int n) {
        int prev = 0;
        int curr = 0;
        for (int i = 0; i < (n - 1); i++) {
            if ((mask & (1 << i)) != 0) {
                final String cut = s.substring(prev, i + 1);
                if (cut.charAt(0) == '0') {
                    return (int) 1e9;
                }
                if (!pow5.contains(Integer.parseInt(cut, 2))) {
                    return (int) 1e9;
                }
                prev = i + 1;
                curr++;
            }
        }
        final String cut = s.substring(prev);
        if (cut.charAt(0) == '0') {
            return (int) 1e9;
        }
        if (!pow5.contains(Integer.parseInt(cut, 2))) {
            return (int) 1e9;
        }
        curr++;
        return curr;
    }
}
