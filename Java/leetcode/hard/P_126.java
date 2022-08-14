package leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_126 {

    static Map<Integer, Set<String>> map;
    static List<List<String>> res;
    static Set<String> wordSet;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        map = new HashMap<>();
        res = new ArrayList<>();
        wordSet = new HashSet<>(wordList);
        int step = 0;
        final Deque<String> dq = new ArrayDeque<>(Collections.singletonList(beginWord));
        final Set<String> seen = new HashSet<>(Collections.singletonList(beginWord));
        boolean found = false;
        outer:
        while (!dq.isEmpty()) {
            final Set<String> curr = new HashSet<>();
            for (int size = dq.size(); size > 0; size--) {
                final String u = dq.removeFirst();
                curr.add(u);
                if (u.equals(endWord)) {
                    found = true;
                    break outer;
                }
                for (String v : nextLevel(u, seen)) {
                    dq.offer(v);
                }
            }
            map.put(step++, curr);
        }
        if (!found) {
            return res;
        }
        final List<String> list = new ArrayList<>(Collections.singletonList(endWord));
        dfs(endWord, step, list);
        return res;
    }

    private static void dfs(String u, int level, List<String> list) {
        if (level == 0) {
            final List<String> copy = new ArrayList<>(list);
            Collections.reverse(copy);
            res.add(copy);
            return;
        }
        final Set<String> seen = new HashSet<>();
        for (String v : map.get(level - 1)) {
            if (isOkay(v, u) && seen.add(v)) {
                list.add(v);
                dfs(v, level - 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private static Set<String> nextLevel(String s, Set<String> seen) {
        final Set<String> res = new HashSet<>();
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            final int c = s.charAt(i);
            for (char nc = 'a'; nc <= 'z'; nc++) {
                if (nc == c) {
                    continue;
                }
                final String u = s.substring(0, i) + nc + s.substring(i + 1);
                if (wordSet.contains(u) && seen.add(u)) {
                    res.add(u);
                }
            }
        }
        return res;
    }

    private static boolean isOkay(String l, String r) {
        final int n = l.length();
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (l.charAt(i) != r.charAt(i)) {
                d++;
            }
        }
        return d == 1;
    }
}
