package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recurse1(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void recurse1(List<List<Integer>> res, List<Integer> curr, int[] nums, int start) {
        res.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) { continue; }
            curr.add(nums[i]);
            recurse1(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recurse2(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void recurse2(List<List<Integer>> res, List<Integer> curr, int[] nums, int start) {
        res.add(new ArrayList<>(curr));
        final Set<Integer> seen = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (seen.add(nums[i])) {
                curr.add(nums[i]);
                recurse2(res, curr, nums, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
