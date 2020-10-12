package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantConditions")
public class P_229 {

    // Boyer-Moore majority vote -> https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null, candidate2 = null;
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        final List<Integer> res = new ArrayList<>();
        final int target = nums.length / 3;
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) { count1++; }
            if (candidate2 != null && num == candidate2) { count2++; }
        }
        if (count1 > target) {
            res.add(candidate1);
        }
        if (count2 > target) {
            res.add(candidate2);
        }
        return res;
    }
}
