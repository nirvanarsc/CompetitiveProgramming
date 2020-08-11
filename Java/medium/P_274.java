package medium;

import java.util.Arrays;

public class P_274 {

    public int hIndexSort(int[] citations) {
        Arrays.sort(citations);
        final int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }

    public int hIndex(int[] citations) {
        final int n = citations.length;
        final int[] buckets = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }

    // upperBound
    public int hIndexBS(int[] citations) {
        int lo = 0;
        int hi = citations.length;
        while(lo < hi) {
            final int mid = (1 + lo + hi) >>> 1;
            int count = 0;
            for(int c: citations) {
                count += c >= mid ? 1:0;
            }
            if(count >= mid) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
