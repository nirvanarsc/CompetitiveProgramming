package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        final List<List<String>> res = new ArrayList<>();
        final Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return res;
        }
        final Map<String, List<String>> map = new HashMap<>();
        final Set<String> startSet = new HashSet<>(Collections.singletonList(beginWord));
        final Set<String> endSet = new HashSet<>(Collections.singletonList(endWord));
        final List<String> list = new ArrayList<>(Collections.singletonList(beginWord));
        bfs(startSet, endSet, words, map, false);
        dfs(beginWord, endWord, map, list, res);
        return res;
    }

    private static void dfs(String start,
                            String endWord,
                            Map<String, List<String>> map,
                            List<String> list,
                            List<List<String>> res) {
        if (start.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (!map.containsKey(start)) {
            return;
        }
        for (String next : map.get(start)) {
            list.add(next);
            dfs(next, endWord, map, list, res);
            list.remove(list.size() - 1);
        }
    }

    private static void bfs(Set<String> startSet,
                            Set<String> endSet,
                            Set<String> words,
                            Map<String, List<String>> map,
                            boolean reverse) {
        if (startSet.isEmpty()) {
            return;
        }
        if (startSet.size() > endSet.size()) {
            bfs(endSet, startSet, words, map, !reverse);
            return;
        }
        final Set<String> nextSet = new HashSet<>();
        boolean finish = false;
        words.removeAll(startSet);
        for (String word : startSet) {
            final char[] curr = word.toCharArray();
            for (int i = 0; i < curr.length; i++) {
                final char old = curr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    curr[i] = c;
                    final String next = new String(curr);
                    if (words.contains(next)) {
                        if (endSet.contains(next)) {
                            finish = true;
                        } else {
                            nextSet.add(next);
                        }
                        final String key = reverse ? next : word;
                        final String value = reverse ? word : next;
                        map.computeIfAbsent(key, val -> new ArrayList<>()).add(value);
                    }
                }
                curr[i] = old;
            }
        }
        if (!finish) {
            bfs(nextSet, endSet, words, map, reverse);
        }
    }
}
