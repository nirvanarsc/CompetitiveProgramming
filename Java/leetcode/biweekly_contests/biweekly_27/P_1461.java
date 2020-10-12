package leetcode.biweekly_contests.biweekly_27;

import java.util.HashSet;
import java.util.Set;

public class P_1461 {

    public boolean hasAllCodes(String s, int k) {
        final Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == (int) Math.pow(2, k);
    }
}
