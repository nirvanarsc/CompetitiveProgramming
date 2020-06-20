package hard;

import java.util.Arrays;

public class P_354 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1])
                                                      : Integer.compare(a[0], b[0]));
        final int[][] dp = new int[envelopes.length][2];
        int len = 0;
        for (int[] envelope : envelopes) {
            final int i = lowerBound(dp, len, envelope);
            dp[i] = envelope;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public int lowerBound(int[][] envelopes, int to, int[] target) {
        int lo = 0, hi = to;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (envelopes[mid][1] < target[1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
