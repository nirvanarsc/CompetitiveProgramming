package weekly_contests.weekly_135;

import java.util.Arrays;

public class P_1040 {

    public int[] numMovesStonesII(int[] stones) {
        final int n = stones.length;
        Arrays.sort(stones);
        int i = 0, low = n;
        final int high = Math.max(stones[n - 1] - stones[1] - n + 2, stones[n - 2] - stones[0] - n + 2);
        for (int j = 0; j < n; ++j) {
            while (stones[j] - stones[i] >= n) {
                ++i;
            }
            if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2) {
                low = Math.min(low, 2);
            } else {
                low = Math.min(low, n - (j - i + 1));
            }
        }
        return new int[] { low, high };
    }
}
