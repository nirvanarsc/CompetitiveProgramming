package leetcode.weekly_contests.weekly_0_99.weekly_78;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_810 {

    public boolean xorGameSG(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return recurse(nums, xor, 0, new boolean[nums.length], new HashMap<>());
    }

    private static boolean recurse(int[] nums, int xor, int t, boolean[] taken, Map<Integer, Boolean> dp) {
        if (t == nums.length || xor == 0) {
            return true;
        }
        if (t == nums.length - 1) {
            return false;
        }
        final int key = taken.hashCode();
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        final Set<Boolean> grundy = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (grundy.size() == 2) {
                break;
            }
            if (!taken[i]) {
                taken[i] = true;
                grundy.add(recurse(nums, xor ^ nums[i], t + 1, taken, dp));
                taken[i] = false;
            }
        }
        final boolean res = grundy.size() == 2 ? true : !grundy.contains(true);
        dp.put(key, res);
        return res;
    }

    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0 || nums.length % 2 == 0;
    }
}
