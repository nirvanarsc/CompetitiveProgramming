package leetcode.biweekly_contests.biweekly_100_199.biweekly_107;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_1 {

    public int maximumNumberOfStringPairs(String[] words) {
        final Set<String> set = new HashSet<>(Arrays.asList(words));
        int res = 0;
        for (String w : words) {
            final String rev = new StringBuilder(w).reverse().toString();
            if (!w.equals(rev) && set.contains(rev)) {
                res++;
            }
        }
        return res / 2;
    }
}
