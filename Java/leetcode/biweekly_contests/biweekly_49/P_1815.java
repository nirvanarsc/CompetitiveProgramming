package leetcode.biweekly_contests.biweekly_49;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_1815 {

    public int maxHappyGroups(int batchSize, int[] groups) {
        final int[] modCount = new int[batchSize];
        for (int group : groups) {
            modCount[group % batchSize]++;
        }
        return modCount[0] + dfs(modCount, groups.length - modCount[0], 0, new HashMap<>());
    }

    private static int dfs(int[] count, int idx, int mod, Map<String, Integer> dp) {
        if (idx == 0) {
            return 0;
        }
        final String key = Arrays.toString(count) + ',' + mod;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int res = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > 0) {
                count[i]--;
                res = Math.max(res, (mod == 0 ? 1 : 0) + dfs(count, idx - 1, (i + mod) % count.length, dp));
                count[i]++;
            }
        }
        dp.put(key, res);
        return res;
    }
}
