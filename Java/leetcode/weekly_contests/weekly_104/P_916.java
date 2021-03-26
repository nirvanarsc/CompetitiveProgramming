package leetcode.weekly_contests.weekly_104;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_916 {

    public List<String> wordSubsets(String[] A, String[] B) {
        final int[] max = new int[26];
        for (String w : B) {
            final int[] curr = new int[26];
            for (char c : w.toCharArray()) {
                curr[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                max[i] = Math.max(max[i], curr[i]);
            }
        }
        final List<String> res = new ArrayList<>();
        for (String w : A) {
            final int[] curr = new int[26];
            for (char c : w.toCharArray()) {
                curr[c - 'a']++;
            }
            boolean ok = true;
            for (int i = 0; i < 26; i++) {
                if (max[i] > curr[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                res.add(w);
            }
        }
        return res;
    }
}
