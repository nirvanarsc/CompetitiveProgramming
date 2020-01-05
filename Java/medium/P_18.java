package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        final List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) { break; }
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) { break; }
                if (j > i + 1 && nums[j] == nums[j - 1]) { continue; }
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    final int curr = nums[i] + nums[j] + nums[low] + nums[high];
                    if (curr == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) { low++; }
                        while (low < high && nums[high] == nums[high - 1]) { high--; }
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
