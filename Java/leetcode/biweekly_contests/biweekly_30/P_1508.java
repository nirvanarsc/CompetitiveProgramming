package leetcode.biweekly_contests.biweekly_30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_1508 {

    private static final int MOD = (int) (1e9 + 7);

    public int rangeSum(int[] nums, int n, int left, int right) {
        final List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sums.add(sum);
            }
        }
        Collections.sort(sums);
        long res = 0;
        for (int i = left - 1; i <= right - 1; i++) {
            res = (res + sums.get(i)) % MOD;
        }
        return (int) res;
    }
}
