package leetcode.biweekly_contests.biweekly_0_99.biweekly_3;

import java.util.HashSet;
import java.util.Set;

public class P_1100 {

    public int numKLenSubstrNoRepeatsOptimized(String s, int k) {
        int res = 0, i = 0;
        final Set<Character> set = new HashSet<>();
        for (int j = 0; j < s.length(); j++) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            set.add(s.charAt(j));
            res += j - i + 1 >= k ? 1 : 0;
        }
        return res;
    }

    public int numKLenSubstrNoRepeats(String s, int k) {
        int res = 0, i = 0;
        final Set<Character> set = new HashSet<>();
        for (int j = 0; j < s.length(); j++) {
            if (set.size() == k) {
                res++;
            }
            while (set.size() == k || set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            set.add(s.charAt(j));
        }
        return res + (set.size() == k ? 1 : 0);
    }
}
