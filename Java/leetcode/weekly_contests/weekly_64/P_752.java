package leetcode.weekly_contests.weekly_64;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_752 {

    public int openLock(String[] deadends, String target) {
        final Set<String> banned = new HashSet<>(Arrays.asList(deadends));
        final Deque<char[]> q = new ArrayDeque<>();
        if (!banned.contains("0000")) {
            q.offerLast("0000".toCharArray());
            banned.add("0000");
        }
        for (int level = 0; !q.isEmpty(); level++) {
            for (int k = q.size(); k > 0; k--) {
                final char[] curr = q.removeFirst();
                if (new String(curr).equals(target)) {
                    return level;
                }
                for (int i = 0; i < 4; i++) {
                    final char[] up = curr.clone();
                    final char[] down = curr.clone();
                    up[i] = up[i] == '9' ? '0' : (char) (down[i] + 1);
                    down[i] = down[i] == '0' ? '9' : (char) (down[i] - 1);
                    final String nextUp = new String(up);
                    final String nextDown = new String(down);
                    if (banned.add(nextUp)) {
                        q.offerLast(up);
                    }
                    if (banned.add(nextDown)) {
                        q.offerLast(down);
                    }
                }
            }
        }
        return -1;
    }

    public int openLockBidirectionalBFS(String[] deadends, String target) {
        final Set<String> banned = new HashSet<>(Arrays.asList(deadends));
        Set<String> begin = new HashSet<>(Collections.singleton("0000"));
        Set<String> end = new HashSet<>(Collections.singleton(target));
        Set<String> temp;
        for (int level = 0; !begin.isEmpty() && !end.isEmpty(); level++) {
            if (begin.size() > end.size()) {
                temp = begin;
                begin = end;
                end = temp;
            }
            temp = new HashSet<>();
            for (String s : begin) {
                if (end.contains(s)) {
                    return level;
                }
                if (banned.contains(s)) {
                    continue;
                }
                banned.add(s);
                final StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < 4; i++) {
                    final char c = sb.charAt(i);
                    final String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    final String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if (!banned.contains(s1)) { temp.add(s1); }
                    if (!banned.contains(s2)) { temp.add(s2); }
                }
            }
            begin = temp;
        }
        return -1;
    }
}
