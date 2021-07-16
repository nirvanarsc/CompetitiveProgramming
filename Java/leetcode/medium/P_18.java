package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        final List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) { continue; }
            for (int j = i + 1; j < n; j++) {
                if (j > (i + 1) && nums[j - 1] == nums[j]) { continue; }
                int lo = j + 1;
                int hi = n - 1;
                while (lo < hi) {
                    if (lo > j + 1 && nums[lo - 1] == nums[lo]) {
                        lo++;
                        continue;
                    }
                    if (hi < n - 1 && nums[hi + 1] == nums[hi]) {
                        hi--;
                        continue;
                    }
                    final int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum > target) {
                        hi--;
                    } else if (sum < target) {
                        lo++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        hi--;
                        lo++;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSumSet(int[] nums, int target) {
        final Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    final int curr = nums[i] + nums[j] + nums[low] + nums[high];
                    if (curr == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                    } else if (curr < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}
