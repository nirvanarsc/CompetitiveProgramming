package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) { break; }
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }
            twoSum(nums, i, -nums[i], res);
        }
        return res;
    }

    private static void twoSum(int[] nums, int start, int target, List<List<Integer>> res) {
        int low = start + 1;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                res.add(Arrays.asList(nums[start], nums[low], nums[high]));
                while (low < high && nums[low] == nums[low + 1]) { low++; }
                while (low < high && nums[high] == nums[high - 1]) { high--; }
                low++;
                high--;
            } else if (nums[low] + nums[high] < target) {
                low++;
            } else {
                high--;
            }
        }
    }
}
