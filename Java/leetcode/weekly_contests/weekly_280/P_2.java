package leetcode.weekly_contests.weekly_280;

import java.util.ArrayList;
import java.util.List;

public class P_2 {

    public int minimumOperations(int[] nums) {
        final int n = nums.length;
        final int m = (int) (1e5 + 5);
        final int[] odd = new int[m];
        final int[] even = new int[m];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ++even[nums[i]];
            } else {
                ++odd[nums[i]];
            }
        }
        final List<int[]> o = new ArrayList<>();
        final List<int[]> e = new ArrayList<>();
        o.add(new int[] { 0, -1 });
        e.add(new int[] { 0, -1 });
        for (int i = 0; i < m; i++) {
            if (odd[i] > 0) {
                o.add(new int[] { odd[i], i });
            }
            if (even[i] > 0) {
                e.add(new int[] { even[i], i });
            }
        }
        o.sort((a, b) -> Integer.compare(b[0], a[0]));
        e.sort((a, b) -> Integer.compare(b[0], a[0]));
        int res = n;
        for (int i = 0; i < Math.min(2, e.size()); i++) {
            for (int j = 0; j < Math.min(2, o.size()); j++) {
                final int L = e.get(i)[1];
                final int c1 = e.get(i)[0];
                final int R = o.get(j)[1];
                final int c2 = o.get(j)[0];
                if (L == R) {
                    res = Math.min(res, n - Math.max(c1, c2));
                } else {
                    res = Math.min(res, n - c1 - c2);
                }
            }
        }
        return res;
    }
}
