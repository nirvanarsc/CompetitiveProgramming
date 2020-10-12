package leetcode.biweekly_contests.biweekly_17;

import java.util.ArrayList;
import java.util.List;

public class P_1313 {

    public int[] decompressRLElist(int[] nums) {
        final List<Integer> al = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                al.add(nums[i + 1]);
            }
        }

        final int[] res = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }

        return res;
    }
}
