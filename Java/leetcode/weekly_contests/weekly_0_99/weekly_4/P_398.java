package leetcode.weekly_contests.weekly_0_99.weekly_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@SuppressWarnings("unused")
public class P_398 {

    static class Solution {
        int[] nums;
        Random rnd;

        Solution(int[] nums) {
            this.nums = nums;
            rnd = new Random();
        }

        public int pick(int target) {
            int result = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target && rnd.nextInt(++count) == 0) {
                    result = i;
                }
            }
            return result;
        }
    }

    static class SolutionMap {
        Map<Integer, List<Integer>> map;

        SolutionMap(int[] nums) {
            map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.computeIfAbsent(nums[i], v -> new ArrayList<>()).add(i);
            }
        }

        public int pick(int target) {
            final Random r = new Random();
            final List<Integer> curr = map.get(target);
            return curr.get(r.nextInt(curr.size()));
        }
    }
}
