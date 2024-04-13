package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_2962 {

    public long countSubarrays(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        final int n = nums.length;
        final int max = Arrays.stream(nums).max().orElse(-1);
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                map.put(map.size() + 1, i);
            }
        }
        long res = 0;
        int curr = 0;
        for (int num : nums) {
            if (num == max) {
                curr++;
            }
            res += n - map.getOrDefault(curr + k - (num == max ? 1 : 0), n);
        }
        return res;
    }
}
