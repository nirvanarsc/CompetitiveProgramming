package leetcode.weekly_contests.weekly_300_399.weekly_321;

import java.util.HashMap;
import java.util.Map;

public class P_4 {

    public int countSubarrays(int[] nums, int k) {
        final int n = nums.length;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            return 0;
        }
        long res = 0;
        int p = 0;
        final Map<Integer, Integer> f = new HashMap<>();
        for (int i = idx; i < n; i++) {
            p += Integer.compare(nums[i], k);
            f.merge(p, 1, Integer::sum);
        }
        int q = 0;
        for (int i = idx; i >= 0; i--) {
            q += Integer.compare(nums[i], k);
            res += f.getOrDefault(-q, 0);
            res += f.getOrDefault(-(q - 1), 0);
        }
        f.clear();
        p = 0;
        for (int i = idx; i >= 0; i--) {
            p += Integer.compare(nums[i], k);
            f.merge(p, 1, Integer::sum);
        }
        q = 0;
        for (int i = idx; i < n; i++) {
            q += Integer.compare(nums[i], k);
            res += f.getOrDefault(-q, 0);
            res += f.getOrDefault(-(q - 1), 0);
        }
        return (int) (res / 2);
    }
}
