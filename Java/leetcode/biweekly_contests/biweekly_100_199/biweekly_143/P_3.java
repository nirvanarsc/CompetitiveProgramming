package leetcode.biweekly_contests.biweekly_100_199.biweekly_143;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        final int n = nums.length;
        final int[][] indexed = new int[3 * n][2];
        final Map<Integer, Integer> f = new HashMap<>();
        int idx = 0;
        for (int num : nums) {
            f.merge(num, 1, Integer::sum);
            indexed[idx++] = new int[] { num - k, 1 };
            indexed[idx++] = new int[] { num, 0 };
            indexed[idx++] = new int[] { num + k, -1 };
        }
        int res = 0;
        int curr = 0;
        Arrays.sort(indexed, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1])
                                                    : Integer.compare(a[0], b[0]));
        for (int[] u : indexed) {
            curr += u[1];
            if (u[1] == 0) {
                final int req = curr - f.get(u[0]);
                res = Math.max(res, Math.min(numOperations, req) + f.get(u[0]));
            } else {
                res = Math.max(res, Math.min(numOperations, curr));
            }
        }
        return res;
    }
}
