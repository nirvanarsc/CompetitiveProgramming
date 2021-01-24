package leetcode.biweekly_contests.biweekly_44;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_1733 {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        final Map<Integer, Set<Integer>> lang = new HashMap<>();
        final boolean[] seen = new boolean[friendships.length];
        for (int i = 0; i < languages.length; i++) {
            for (int l : languages[i]) {
                lang.computeIfAbsent(i + 1, val -> new HashSet<>()).add(l);
            }
        }
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < friendships.length; i++) {
                if (lang.get(friendships[i][0]).contains(j) && lang.get(friendships[i][1]).contains(j)) {
                    seen[i] = true;
                }
            }
        }
        int res = (int) 1e9;
        for (int i = 1; i <= n; i++) {
            final Set<Integer> teachSet = new HashSet<>();
            for (int j = 0; j < friendships.length; j++) {
                if (seen[j]) { continue; }
                if (!lang.get(friendships[j][0]).contains(i)) { teachSet.add(friendships[j][0]); }
                if (!lang.get(friendships[j][1]).contains(i)) { teachSet.add(friendships[j][1]); }
            }
            res = Math.min(teachSet.size(), res);
        }
        return res;
    }
}
