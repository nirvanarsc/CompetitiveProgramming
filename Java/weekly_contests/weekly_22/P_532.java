package weekly_contests.weekly_22;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_532 {

    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        final Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findPairsBF(int[] nums, int k) {
        final Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[j] - nums[i]) == k && set.add(nums[i] + "," + nums[j])) {
                    res++;
                }
            }
        }
        return res;
    }
}
