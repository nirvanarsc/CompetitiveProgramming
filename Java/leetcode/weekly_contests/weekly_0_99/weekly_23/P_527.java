package leetcode.weekly_contests.weekly_0_99.weekly_23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_527 {

    static class Trie {
        int cnt;
        Trie[] children = new Trie[26];
    }

    public List<String> wordsAbbreviation(List<String> dict) {
        final Map<String, List<Integer>> abbrMap = new HashMap<>();
        final String[] res = new String[dict.size()];
        for (int i = 0; i < dict.size(); i++) {
            final String st = getShortestAbbr(dict.get(i));
            abbrMap.computeIfAbsent(st, k -> new ArrayList<>()).add(i);
        }
        for (Map.Entry<String, List<Integer>> entry : abbrMap.entrySet()) {
            final List<Integer> pos = entry.getValue();
            if (pos.size() == 1) {
                res[pos.get(0)] = entry.getKey();
            } else {
                resolve(dict, res, pos);
            }
        }
        return Arrays.asList(res);
    }

    private static void resolve(List<String> dict, String[] res, List<Integer> pos) {
        final Trie root = buildTrie(dict, pos);
        for (int p : pos) {
            String w = dict.get(p);
            Trie curr = root;
            int i = 0;
            final int n = w.length();
            while (i < n && curr.children[w.charAt(i) - 'a'].cnt > 1) {
                curr = curr.children[w.charAt(i) - 'a'];
                i++;
            }
            if (i < n - 3) {
                w = w.substring(0, i + 1) + (n - i - 2) + w.charAt(n - 1);
            }
            res[p] = w;
        }
    }

    private static String getShortestAbbr(String s) {
        if (s.length() <= 3) {
            return s;
        }
        return String.valueOf(s.charAt(0)) + (s.length() - 2) + s.charAt(s.length() - 1);
    }

    private static Trie buildTrie(List<String> dict, List<Integer> pos) {
        final Trie root = new Trie();
        for (int p : pos) {
            final String w = dict.get(p);
            Trie curr = root;
            for (int i = 0; i < w.length(); i++) {
                final char c = w.charAt(i);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Trie();
                }
                curr = curr.children[c - 'a'];
                curr.cnt++;
            }
        }
        return root;
    }
}
