package leetcode.weekly_contests.weekly_275;

import java.util.HashSet;
import java.util.Set;

public class P_3 {

    public int wordCount(String[] startWords, String[] targetWords) {
        final Set<Integer> ok = new HashSet<>();
        for (String w : startWords) {
            int curr = 0;
            for (char c : w.toCharArray()) {
                curr |= 1 << (c - 'a');
            }
            ok.add(curr);
        }
        int res = 0;
        outer:
        for (String t : targetWords) {
            int curr = 0;
            for (char c : t.toCharArray()) {
                curr |= 1 << (c - 'a');
            }
            for (int i = 0; i < 26; i++) {
                if ((curr & (1 << i)) != 0) {
                    if (ok.contains(curr ^ (1 << i))) {
                        res++;
                        continue outer;
                    }
                }
            }
        }
        return res;
    }
}
