package leetcode.weekly_contests.weekly_300_399.weekly_361;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_3 {

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        final Map<Integer, Long> f = new HashMap<>(Map.of(0, 1L));
        int curr = 0;
        long res = 0;
        for (int num : nums) {
            curr += num % modulo == k ? 1 : 0;
            curr %= modulo;
            res += f.getOrDefault((curr - k + modulo) % modulo, 0L);
            f.merge(curr, 1L, Long::sum);
        }
        return res;
    }
}
