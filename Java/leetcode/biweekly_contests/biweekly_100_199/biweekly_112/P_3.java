package leetcode.biweekly_contests.biweekly_100_199.biweekly_112;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_3 {

    public long maxSum(List<Integer> nums, int m, int k) {
        final int n = nums.size();
        final Map<Integer, Integer> f = new HashMap<>();
        long res = 0;
        long curr = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            curr += nums.get(i);
            f.merge(nums.get(i), 1, Integer::sum);
            if ((i - j + 1) > k) {
                if (f.merge(nums.get(j), -1, Integer::sum) == 0) {
                    f.remove(nums.get(j));
                }
                curr -= nums.get(j++);
            }
            if (f.size() >= m) {
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
