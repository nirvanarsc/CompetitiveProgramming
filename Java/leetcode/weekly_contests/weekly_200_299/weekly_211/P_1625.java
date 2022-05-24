package leetcode.weekly_contests.weekly_200_299.weekly_211;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_1625 {

    public String findLexSmallestString(String s, int a, int b) {
        final int n = s.length();
        String res = s;
        final Deque<String> q = new ArrayDeque<>(Collections.singleton(s));
        final Set<String> seen = new HashSet<>(Collections.singleton(s));
        while (!q.isEmpty()) {
            final String curr = q.removeFirst();
            if (res.compareTo(curr) > 0) {
                res = curr;
            }
            final char[] chars = curr.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                final char c = (char) ((chars[i] - '0' + a) % 10 + '0');
                chars[i] = c;
            }
            final String addA = String.valueOf(chars);
            final String rotate = curr.substring(n - b) + curr.substring(0, n - b);
            if (seen.add(addA)) { q.offerLast(addA); }
            if (seen.add(rotate)) { q.offerLast(rotate); }
        }
        return res;
    }
}
