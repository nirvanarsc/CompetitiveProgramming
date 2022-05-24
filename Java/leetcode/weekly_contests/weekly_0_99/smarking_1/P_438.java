package leetcode.weekly_contests.weekly_0_99.smarking_1;

import java.util.ArrayList;
import java.util.List;

public class P_438 {

    public List<Integer> findAnagrams(String s, String p) {
        final int[] map = new int[128];
        final char[] w = s.toCharArray();
        final int n = w.length;
        final int m = p.length();
        for (char c : p.toCharArray()) {
            map[c]++;
        }
        int j = 0;
        int k = m;
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map[w[i]]-- > 0) {
                k--;
            }
            while (k == 0) {
                if (i - j + 1 == m) {
                    res.add(j);
                }
                if (++map[w[j++]] > 0) {
                    k++;
                }
            }
        }
        return res;
    }
}
