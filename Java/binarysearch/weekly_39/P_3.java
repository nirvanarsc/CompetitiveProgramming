package binarysearch.weekly_39;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int solve(int[] nums, int[] target) {
        if (target.length == 0) {
            return 0;
        }
        final int n = nums.length;
        final Map<Integer, Integer> f = new HashMap<>();
        final Set<Integer> uniq = new HashSet<>();
        for (int num : target) {
            uniq.add(num);
        }
        int k = uniq.size();
        int j = 0;
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (uniq.contains(nums[i])) {
                k -= f.merge(nums[i], 1, Integer::sum) == 1 ? 1 : 0;
            }
            while (j < n && k == 0) {
                count += n - i;
                if (uniq.contains(nums[j])) {
                    k += f.merge(nums[j], -1, Integer::sum) == 0 ? 1 : 0;
                }
                j++;
            }
        }
        final long total = (long) n * (n + 1) / 2;
        return (int) ((total - count) % MOD);
    }
}
