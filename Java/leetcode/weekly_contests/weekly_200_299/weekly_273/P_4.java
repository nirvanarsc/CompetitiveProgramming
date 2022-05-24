package leetcode.weekly_contests.weekly_200_299.weekly_273;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({ "ReturnOfNull", "ConstantConditions" })
public class P_4 {

    public int[] recoverArray(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                final int k = nums[j] - nums[i];
                if (k > 0 && k % 2 == 0) {
                    final int[] res = f(nums, n, k);
                    if (res != null) {
                        return res;
                    }
                }
            }
        }
        return null;
    }

    private static int[] f(int[] nums, int n, int k) {
        final List<Integer> res = new ArrayList<>(n / 2);
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (int num : nums) {
            if (map.get(num) == 0) {
                continue;
            }
            if (map.getOrDefault(num + k, 0) == 0) {
                return null;
            }
            map.merge(num, -1, Integer::sum);
            map.merge(num + k, -1, Integer::sum);
            res.add(num + k / 2);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
