package leetcode.weekly_contests.weekly_293;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public List<String> removeAnagrams(String[] words) {
        final List<String> res = new ArrayList<>();
        final int n = words.length;
        res.add(words[0]);
        for (int i = 1; i < n; i++) {
            if (f(words[i], res.get(res.size() - 1))) {
                continue;
            }
            res.add(words[i]);
        }
        return res;
    }

    private static boolean f(String l, String r) {
        final int[] f = new int[26];
        for (char c : l.toCharArray()) {
            f[c - 'a']++;
        }
        for (char c : r.toCharArray()) {
            f[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (f[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
