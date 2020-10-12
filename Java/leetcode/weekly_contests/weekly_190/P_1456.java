package leetcode.weekly_contests.weekly_190;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_1456 {

    public int maxVowels(String s, int k) {
        final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int res = 0, curr = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            curr += vowels.contains(s.charAt(i)) ? 1 : 0;
            k--;
            if (k == 0) {
                res = Math.max(res, curr);
                curr -= vowels.contains(s.charAt(j++)) ? 1 : 0;
                k++;
            }
        }
        return res;
    }
}
