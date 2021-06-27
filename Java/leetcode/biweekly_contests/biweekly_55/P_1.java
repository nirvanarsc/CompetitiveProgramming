package leetcode.biweekly_contests.biweekly_55;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public boolean canBeIncreasing(int[] nums) {
        outer:
        for (int i = 0; i < nums.length; i++) {
            final List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    list.add(nums[j]);
                }
            }
            for (int j = 0; j < list.size() - 1; j++) {
                if (!(list.get(j) < list.get(j + 1))) {
                    continue outer;
                }
            }
            return true;
        }
        return false;
    }
}
