package leetcode.biweekly_contests.biweekly_0_99.biweekly_48;

import java.util.TreeSet;

@SuppressWarnings("ConstantConditions")
public class P_1796 {

    public int secondHighest(String s) {
        final TreeSet<Integer> d = new TreeSet<>();
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                d.add(c - '0');
            }
        }
        if (d.size() <= 1) {
            return -1;
        }
        d.pollLast();
        return d.pollLast();
    }
}
