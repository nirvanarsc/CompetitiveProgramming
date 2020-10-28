package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class P_228 {

    public List<String> summaryRanges(int[] nums) {
        final List<String> res = new ArrayList<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n - 1 && nums[j + 1] == nums[j] + 1) {
                j++;
            }
            if (i == j) {
                res.add(String.valueOf(nums[i]));
            } else {
                res.add(nums[i] + "->" + nums[j]);
            }
            i = j;
        }
        return res;
    }
}
