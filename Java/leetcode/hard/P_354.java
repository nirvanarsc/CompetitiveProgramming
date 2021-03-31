package leetcode.hard;

import java.util.Arrays;

public class P_354 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1])
                                                      : Integer.compare(a[0], b[0]));
        final int[] lis = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            final int idx = lowerBound(lis, len, envelope[1]);
            lis[idx] = envelope[1];
            if (len == idx) {
                len++;
            }
        }
        return len;
    }

    private static int lowerBound(int[] arr, int to, int target) {
        int lo = 0;
        int hi = to;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
