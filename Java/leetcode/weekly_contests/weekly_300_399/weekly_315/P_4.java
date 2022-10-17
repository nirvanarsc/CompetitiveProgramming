package leetcode.weekly_contests.weekly_300_399.weekly_315;

import java.util.ArrayList;
import java.util.List;

public class P_4 {

    public long countSubarrays(int[] nums, int minK, int maxK) {
        final List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for (int num : nums) {
            if (!(minK <= num && num <= maxK)) {
                if (!curr.isEmpty()) {
                    list.add(curr);
                    curr = new ArrayList<>();
                }
            } else {
                curr.add(num);
            }
        }
        if (!curr.isEmpty()) {
            list.add(curr);
        }
        long res = 0;
        for (List<Integer> l : list) {
            res += f(l, maxK, minK);
        }
        return res;
    }

    private static long f(List<Integer> l, int max, int min) {
        final int n = l.size();
        final int[] pmax = new int[n + 1];
        final int[] pmin = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pmax[i] = pmax[i - 1] + (l.get(i - 1) == max ? 1 : 0);
            pmin[i] = pmin[i - 1] + (l.get(i - 1) == min ? 1 : 0);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            int lo = i;
            int hi = n;
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if ((pmax[mid + 1] - pmax[i] > 0) && (pmin[mid + 1] - pmin[i] > 0)) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            res += n - lo;
        }
        return res;
    }
}
