package leetcode.weekly_contests.weekly_100_199.weekly_198;

import java.util.HashSet;
import java.util.Set;

public class P_1521 {

    public int closestToTargetSet(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        int res = (int) 1e9;
        for (int value : arr) {
            final Set<Integer> next = new HashSet<>();
            next.add(value);
            for (int num : set) {
                next.add(num & value);
            }
            for (int num : next) {
                res = Math.min(res, Math.abs(num - target));
            }
            set = next;
        }
        return res;
    }

    public int closestToTarget(int[] arr, int target) {
        final int n = arr.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            for (int r = i; r < n; r++) {
                sum &= arr[r];
                res = Math.min(res, Math.abs(sum - target));
                if (res == 0) { return 0; }
                if (sum == 0 || sum <= target - res) { break; }
            }
            if (sum > target) { break; }
        }
        return res;
    }
}
