package leetcode.weekly_contests.weekly_300_399.weekly_308;

import java.util.Arrays;

public class P_1 {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        final int n = queries.length;
        for (int i = 0; i < n; i++) {
            int s = queries[i];
            int curr = 0;
            for (int num : nums) {
                if (s < num) {
                    break;
                }
                s -= num;
                curr++;
            }
            queries[i] = curr;
        }
        return queries;
    }
}
