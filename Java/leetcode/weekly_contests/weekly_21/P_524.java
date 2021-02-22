package leetcode.weekly_contests.weekly_21;

import java.util.ArrayList;
import java.util.List;

public class P_524 {

    public String findLongestWord(String s, List<String> d) {
        final List<List<Integer>> g = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < s.length(); i++) {
            g.get(s.charAt(i) - 'a').add(i);
        }
        String res = "";
        outer:
        for (String w : d) {
            if (w.length() > s.length() || res.length() > w.length()) {
                continue;
            }
            int i = 0;
            for (char c : w.toCharArray()) {
                final int lb = lowerBound(i, g.get(c - 'a'));
                if (lb == -1) {
                    continue outer;
                }
                i = g.get(c - 'a').get(lb) + 1;
            }
            if (res.length() < w.length() || w.compareTo(res) < 0) {
                res = w;
            }
        }
        return res;
    }

    private static int lowerBound(int target, List<Integer> list) {
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
        return lo == list.size() ? -1 : lo;
    }

    public String findLongestWordOld(String s, List<String> d) {
        return d.stream()
                .filter(word -> isSubsequence(s, word))
                .max((a, b) -> a.length() == b.length() ? b.compareTo(a)
                                                        : Integer.compare(a.length(), b.length()))
                .orElse("");
    }

    private static boolean isSubsequence(String a, String b) {
        int j = 0;
        for (int i = 0; i < a.length(); i++) {
            if (j < b.length() && a.charAt(i) == b.charAt(j)) {
                j++;
            }
        }
        return j == b.length();
    }
}
