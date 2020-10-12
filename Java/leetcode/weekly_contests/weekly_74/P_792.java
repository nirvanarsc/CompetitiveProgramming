package leetcode.weekly_contests.weekly_74;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_792 {

    public int numMatchingSubseq(String S, String[] words) {
        final Map<Character, List<Integer>> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            map.computeIfAbsent(S.charAt(i), v -> new ArrayList<>()).add(i);
        }
        for (String w : words) {
            if (isSubsequence(map, w)) {
                res++;
            }
        }
        return res;
    }

    public boolean isSubsequence(Map<Character, List<Integer>> map, String s) {
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            final List<Integer> list = map.getOrDefault(s.charAt(i), Collections.emptyList());
            int j = Collections.binarySearch(list, prev);
            if (j < 0) { j = -j - 1; }
            if (j == list.size()) {
                return false;
            }
            prev = list.get(j) + 1;
        }
        return true;
    }

    static class Pair {
        String word;
        int index;

        Pair(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }

    public int numMatchingSubseqQueue(String S, String[] words) {
        final Map<Integer, Deque<Pair>> g = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            g.put(i, new ArrayDeque<>());
        }
        for (String word : words) {
            g.get(word.charAt(0) - 'a').offerLast(new Pair(word, 0));
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            final Deque<Pair> queue = g.get(c - 'a');
            for (int i = queue.size(); i > 0; i--) {
                final Pair top = queue.remove();
                top.index++;
                if (top.index == top.word.length()) {
                    count++;
                } else {
                    g.get(top.word.charAt(top.index) - 'a').offerLast(top);
                }
            }
        }
        return count;
    }
}
