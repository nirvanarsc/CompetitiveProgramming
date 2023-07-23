package leetcode.biweekly_contests.biweekly_100_199.biweekly_103;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_4 {

    public long countOperationsToEmptyArray(int[] nums) {
        final int n = nums.length;
        final Map<Integer, Integer> idx = new HashMap<>();
        long res = n;
        for (int i = 0; i < n; i++) {
            idx.put(nums[i], i);
        }
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (idx.get(nums[i - 1]) > idx.get(nums[i])) {
                res += n - i;
            }
        }
        return res;
    }
}
