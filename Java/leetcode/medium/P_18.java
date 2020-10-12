package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        final List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) { continue; }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) { continue; }
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[i] + nums[j] + nums[start] + nums[end] < target) {
                        start++;
                    } else if (nums[i] + nums[j] + nums[start] + nums[end] > target) {
                        end--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        while (start < end && nums[start + 1] == nums[start]) { start++; }
                        while (start < end && nums[end - 1] == nums[end]) { end--; }
                        start++;
                        end--;
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
