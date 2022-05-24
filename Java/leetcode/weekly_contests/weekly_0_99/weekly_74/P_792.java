package leetcode.weekly_contests.weekly_0_99.weekly_74;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_792 {

    public int numMatchingSubseq(String s, String[] words) {
        final List<List<Integer>> g = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            g.add(new ArrayList<>());
        }
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            g.get(s.charAt(i) - 'a').add(i);
        }
        int res = 0;
        for (String w : words) {
            if (isSubsequence(g, w)) {
                res++;
            }
        }
        return res;
    }

    private static boolean isSubsequence(List<List<Integer>> g, String w) {
        int prev = 0;
        for (int i = 0; i < w.length(); i++) {
            final List<Integer> list = g.get(w.charAt(i) - 'a');
            final int lb = lowerBound(list, prev);
            if (lb == list.size() || list.get(lb) < prev) {
                return false;
            }
            prev = list.get(lb) + 1;
        }
        return true;
    }

    private static int lowerBound(List<Integer> list, int target) {
        int lo = 0;
        int hi = list.size();
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (list.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
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
