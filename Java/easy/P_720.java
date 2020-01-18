package easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P_720 {

    public String longestWordSort(String[] words) {
        Arrays.sort(words);
        final Set<String> built = new HashSet<>();
        String res = "";
        for (String w : words) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;
                built.add(w);
            }
        }
        return res;
    }

    public String longestWordTrie(String[] words) {
        final Set<String> hs = new HashSet<>();
        Collections.addAll(hs, words);

        int max = 0;
        String ans = "";
        for (String w : words) {
            if (helper(w, hs)) {
                if (w.length() > max) {
                    max = w.length();
                    ans = w;
                } else if (w.length() == max) {
                    ans = w.compareTo(ans) > 0 ? ans : w;
                }
            }
        }
        return ans;
    }

    public boolean helper(String w, Set<String> hs) {
        for (int i = 1; i < w.length(); i++) {
            final String sub = w.substring(0, i);
            if (!hs.contains(sub)) {
                return false;
            }
        }
        return true;
    }
}
