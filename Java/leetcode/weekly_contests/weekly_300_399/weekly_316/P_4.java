package leetcode.weekly_contests.weekly_300_399.weekly_316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_4 {

    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        final List<Integer> oddL = new ArrayList<>();
        final List<Integer> evenL = new ArrayList<>();
        final List<Integer> oddR = new ArrayList<>();
        final List<Integer> evenR = new ArrayList<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                evenL.add(nums[i]);
            } else {
                oddL.add(nums[i]);
            }
            if (target[i] % 2 == 0) {
                evenR.add(target[i]);
            } else {
                oddR.add(target[i]);
            }
        }
        long res = 0;
        for (int i = 0; i < oddL.size(); i++) {
            if (oddL.get(i) > oddR.get(i)) {
                res += (oddL.get(i) - oddR.get(i)) / 2;
            }
        }
        for (int i = 0; i < evenL.size(); i++) {
            if (evenL.get(i) > evenR.get(i)) {
                res += (evenL.get(i) - evenR.get(i)) / 2;
            }
        }
        return res;
    }
}
