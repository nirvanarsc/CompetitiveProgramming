package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class P_78 {

    public static List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            final List<Integer> curr = new ArrayList<>();
            int num = i, idx = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    curr.add(nums[idx]);
                }
                num >>= 1;
                idx++;
            }
            res.add(curr);
        }

        return res;
    }

    public static List<List<Integer>> subsetsBacktrack(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recurse(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void recurse(List<List<Integer>> res, List<Integer> curr, int[] nums, int start) {
        res.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            recurse(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[] { 1, 2, 3 }));
        System.out.println(subsets(new int[] { 0 }));

        System.out.println(subsetsBacktrack(new int[] { 1, 2, 3 }));
        System.out.println(subsetsBacktrack(new int[] { 0 }));
    }

    private P_78() {}
}
