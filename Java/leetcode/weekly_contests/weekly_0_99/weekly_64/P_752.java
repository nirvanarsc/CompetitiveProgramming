package leetcode.weekly_contests.weekly_0_99.weekly_64;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_752 {

    public int openLock(String[] deadends, String target) {
        final Deque<String> dq = new ArrayDeque<>();
        dq.offerLast("0000");
        final Set<String> seen = new HashSet<>();
        final Set<String> banned = new HashSet<>(Arrays.asList(deadends));
        for (int level = 0; !dq.isEmpty(); level++) {
            for (int size = dq.size(); size > 0; size--) {
                final String curr = dq.removeFirst();
                if (banned.contains(curr)) { continue; }
                if (!seen.add(curr)) { continue; }
                if (curr.equals(target)) { return level; }
                final char[] w = curr.toCharArray();
                for (int i = 0; i < 4; i++) {
                    final int c = w[i] - '0';
                    add(dq, curr.toCharArray(), i, (c + 1) % 10);
                    add(dq, curr.toCharArray(), i, (c - 1 + 10) % 10);
                }
            }
        }
        return -1;
    }

    private static void add(Deque<String> dq, char[] w, int idx, int num) {
        w[idx] = (char) (num + '0');
        dq.offerLast(new String(w));
    }

    public int openLockBidirectionalBFS(String[] deadends, String target) {
        final Set<String> banned = new HashSet<>(Arrays.asList(deadends));
        Set<String> l = new HashSet<>(Collections.singleton("0000"));
        Set<String> r = new HashSet<>(Collections.singleton(target));
        Set<String> temp;
        for (int level = 0; !l.isEmpty() && !r.isEmpty(); level++) {
            if (l.size() > r.size()) {
                temp = l;
                l = r;
                r = temp;
            }
            temp = new HashSet<>();
            for (String curr : l) {
                if (!banned.add(curr)) { continue; }
                if (r.contains(curr)) { return level; }
                final char[] w = curr.toCharArray();
                for (int i = 0; i < 4; i++) {
                    final int c = w[i] - '0';
                    add(temp, curr.toCharArray(), i, (c + 1) % 10);
                    add(temp, curr.toCharArray(), i, (c - 1 + 10) % 10);
                }
            }
            l = temp;
        }
        return -1;
    }

    private static void add(Set<String> set, char[] w, int idx, int num) {
        w[idx] = (char) (num + '0');
        set.add(new String(w));
    }
}
