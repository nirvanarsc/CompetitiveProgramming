package leetcode.biweekly_contests.biweekly_100_199.biweekly_154;

import java.util.Arrays;

public class P_3 {

    public int uniqueXorTriplets(int[] nums) {
        final int[] map = new int[1 << 11];
        final boolean[] seen = new boolean[1 << 11];
        final int n = nums.length;
        Arrays.fill(map, -1);
        for (int j = 0; j < n; j++) {
            for (int k = j; k < n; k++) {
                map[nums[j] ^ nums[k]] = j;
            }
        }
        int res = 0;
        for (int u = 0; u < 1 << 11; u++) {
            for (int i = 0; i <= map[u]; i++) {
                if (!seen[nums[i] ^ u]) {
                    seen[nums[i] ^ u] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
