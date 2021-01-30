package leetcode.biweekly_contests.biweekly_34;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_1574 {

    public int findLengthOfShortestSubarray(int[] arr) {
        boolean sorted = true;
        final int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            sorted &= arr[i] <= arr[i + 1];
        }
        if (sorted) {
            return 0;
        }
        final List<Integer> f = new ArrayList<>();
        f.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] <= arr[i]) {
                f.add(arr[i]);
            } else {
                break;
            }
        }
        final List<Integer> b = new ArrayList<>();
        b.add(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                b.add(arr[i]);
            } else {
                break;
            }
        }
        Collections.reverse(b);
        int res = Math.max(f.size(), b.size());
        for (int i = 0; i < f.size(); i++) {
            final int o = lowerBound(b, f.get(i));
            final int curr = i + 1 + b.size() - o;
            res = Math.max(res, curr);
        }
        return n - res;
    }

    private static int lowerBound(List<Integer> l, int tar) {
        int lo = 0, hi = l.size();
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (l.get(mid) < tar) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
