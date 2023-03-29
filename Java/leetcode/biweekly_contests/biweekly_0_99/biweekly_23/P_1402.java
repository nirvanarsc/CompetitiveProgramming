package leetcode.biweekly_contests.biweekly_0_99.biweekly_23;

import java.util.Arrays;

public class P_1402 {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        final int n = satisfaction.length;
        int sum = 0;
        int pre = 0;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += satisfaction[i];
            pre += sum;
            res = Math.max(res, pre);
        }
        return res;
    }
}
