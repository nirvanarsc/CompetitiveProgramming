package weekly_contests.weekly_207;

import java.util.HashSet;
import java.util.Set;

public class P_1593 {

    public int maxUniqueSplit(String s) {
        final int[] res = { 0 };
        final Set<String> set = new HashSet<>();
        dfs(s, set, res);
        return res[0];
    }

    private static void dfs(String s, Set<String> seen, int[] res) {
        if (s.isEmpty()) {
            res[0] = Math.max(res[0], seen.size());
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            final String curr = s.substring(0, i);
            if (!seen.contains(curr)) {
                seen.add(curr);
                dfs(s.substring(i), seen, res);
                seen.remove(curr);
            }
        }
    }
}
