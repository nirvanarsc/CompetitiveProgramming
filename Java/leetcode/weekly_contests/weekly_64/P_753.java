package leetcode.weekly_contests.weekly_64;

import java.util.HashSet;
import java.util.Set;

public class P_753 {

    Set<String> seen;
    StringBuilder ans;

    public String crackSafe(int n, int k) {
        seen = new HashSet<>();
        ans = new StringBuilder();

        final StringBuilder sb = new StringBuilder();
        sb.append("0".repeat(Math.max(0, n - 1)));
        final String start = sb.toString();

        dfs(start, k);
        ans.append(start);
        return new String(ans);
    }

    public void dfs(String node, int k) {
        for (int x = 0; x < k; ++x) {
            final String nei = node + x;
            if (!seen.contains(nei)) {
                seen.add(nei);
                dfs(nei.substring(1), k);
                ans.append(x);
            }
        }
    }
}
