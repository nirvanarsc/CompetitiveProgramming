package binarysearch.weekly_56;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_2 {

    public int[] solve(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }
            map.put(idx++, nums[i]);
        }
        final List<Integer> res = new ArrayList<>();
        idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] != nums[i]) { idx++; }
            if (isPeak(nums[i], idx, map)) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static boolean isPeak(int num, int idx, Map<Integer, Integer> map) {
        final Integer left = map.get(idx - 1);
        final Integer right = map.get(idx + 1);
        if (left != null && left > num) {
            return false;
        }
        if (right != null && right > num) {
            return false;
        }
        return left != null || right != null;
    }
}
