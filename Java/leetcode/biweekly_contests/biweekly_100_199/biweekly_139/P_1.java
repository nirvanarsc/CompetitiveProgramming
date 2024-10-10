package leetcode.biweekly_contests.biweekly_100_199.biweekly_139;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public List<Integer> stableMountains(int[] height, int threshold) {
        final int n = height.length;
        final List<Integer> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (height[i - 1] > threshold) {
                res.add(i);
            }
        }
        return res;
    }
}
