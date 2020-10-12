package leetcode.weekly_contests.weekly_160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1237 {

    @FunctionalInterface
    interface CustomFunction {
        int f(int x, int y);
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        final List<List<Integer>> res = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            for (int y = 1; y <= 1000; y++) {
                if (customfunction.f(x, y) == z) {
                    res.add(Arrays.asList(x, y));
                }
            }
        }
        return res;
    }

    public List<List<Integer>> findSolutionBinarySearch(CustomFunction customfunction, int z) {
        final List<List<Integer>> ans = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            int l = 1, r = 1001;
            while (l < r) {
                final int mid = l + r >>> 1;
                if (customfunction.f(x, mid) < z) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (customfunction.f(x, l) == z) {
                ans.add(Arrays.asList(x, l));
            }
        }
        return ans;
    }

    public List<List<Integer>> findSolutionLinearSearch(CustomFunction customfunction, int z) {
        final List<List<Integer>> res = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y > 0) {
            final int v = customfunction.f(x, y);
            if (v > z) {
                --y;
            } else if (v < z) {
                ++x;
            } else {
                res.add(Arrays.asList(x++, y--));
            }
        }
        return res;
    }
}
