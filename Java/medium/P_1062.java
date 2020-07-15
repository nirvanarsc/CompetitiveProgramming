package medium;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_1062 {

    private static final int MOD = (int) (1e9 + 7);
    private static final int SIZE = 26;

    public static int search(int mid, long[] diff, int[] nums) {
        final Set<Long> seen = new HashSet<>();
        long hash = 0;
        for (int i = 0; i < nums.length; i++) {
            hash = (hash * SIZE + nums[i]) % MOD;
            if (i >= mid) {
                hash = Math.floorMod(hash - Math.floorMod(nums[i - mid] * diff[mid], MOD), MOD);
            }
            if (i >= mid - 1 && !seen.add(hash)) {
                return i;
            }
        }
        return -1;
    }

    public int longestRepeatingSubstring(String S) {
        final int n = S.length();
        final int[] nums = new int[n];
        final long[] diff = new long[n];
        for (int i = 0; i < n; i++) {
            diff[i] = i == 0 ? 1 : (diff[i - 1] * SIZE) % MOD;
            nums[i] = S.charAt(i) - 'a';
        }
        int lo = 0, hi = n;
        while (lo < hi) {
            final int mid = (1 + lo + hi) >>> 1;
            if (search(mid, diff, nums) != -1) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
