package leetcode.biweekly_contests.biweekly_23;

import java.util.Arrays;

public class P_1402 {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum = 0, curr = 0, res = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            sum += satisfaction[i];
            curr += sum;
            res = Math.max(res, curr);
        }
        return res;
    }

    public int maxSatisfactionBF(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            int curr = 0;
            int idx = 1;
            for (int j = i; j < satisfaction.length; j++) {
                curr += idx++ * satisfaction[j];
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
