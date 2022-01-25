package leetcode.weekly_contests.weekly_277;

import java.util.ArrayList;
import java.util.List;

public class P_3 {

    public List<Integer> findLonely(int[] nums) {
        final int n = (int) (1e6 + 5);
        final int[] f = new int[n];
        for (int num : nums) {
            f[num]++;
        }
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (f[i] == 1 && (i == 0 || f[i - 1] == 0) && f[i + 1] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
