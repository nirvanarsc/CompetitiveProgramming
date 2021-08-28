package leetcode.weekly_contests.weekly_159;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unused")
public class P_1235 {

    static boolean[] seen;
    static int[] dp;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        final int n = startTime.length;
        seen = new boolean[n];
        dp = new int[n];
        final int[][] indexed = new int[n][3];
        for (int i = 0; i < n; i++) {
            indexed[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }
        Arrays.sort(indexed, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1])
                                                    : Integer.compare(a[0], b[0]));
        return dfs(indexed, 0);
    }

    private static int dfs(int[][] arr, int idx) {
        if (idx == arr.length) {
            return 0;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        int res = 0;
        res = Math.max(res, arr[idx][2] + dfs(arr, lowerBound(arr, arr[idx][1])));
        res = Math.max(res, dfs(arr, idx + 1));
        seen[idx] = true;
        return dp[idx] = res;
    }

    private static int lowerBound(int[][] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int jobSchedulingBottomUp(int[] startTime, int[] endTime, int[] profit) {
        final int[][] items = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            items[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }
        Arrays.sort(items, Comparator.comparingInt(a -> a[1]));
        final List<Integer> dpEndTime = new ArrayList<>(Collections.singleton(0));
        final List<Integer> dpProfit = new ArrayList<>(Collections.singleton(0));
        for (int[] item : items) {
            final int s = item[0];
            final int e = item[1];
            final int p = item[2];
            int prevIdx = Collections.binarySearch(dpEndTime, s + 1);
            if (prevIdx < 0) {
                prevIdx = -prevIdx - 1;
            }
            prevIdx--;
            final int currProfit = dpProfit.get(prevIdx) + p;
            final int maxProfit = dpProfit.get(dpProfit.size() - 1);
            if (currProfit > maxProfit) {
                dpProfit.add(currProfit);
                dpEndTime.add(e);
            }
        }
        return dpProfit.get(dpProfit.size() - 1);
    }

    static class UpperBound {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            final int n = startTime.length;
            final List<int[]> job = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                job.add(new int[] { startTime[i], endTime[i], profit[i] });
            }
            job.sort(Comparator.comparingInt(a -> a[1]));
            return dfs(job, n, new Integer[n + 1]);
        }

        public int dfs(List<int[]> job, int start, Integer[] dp) {
            if (start == 0) {
                return 0;
            }
            if (dp[start] != null) {
                return dp[start];
            }
            final int skip = dfs(job, start - 1, dp);
            final int take = job.get(start - 1)[2] + dfs(job, upperBound(job, start), dp);
            return dp[start] = Math.max(take, skip);
        }

        // actual match is at lo-1 => (lo == i) ? -1 : lo - 1;
        public int upperBound(List<int[]> job, int i) {
            int lo = 0, hi = i;
            final int target = job.get(i - 1)[0] + 1;
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (job.get(mid)[1] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }

    static class LowerBound {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            final int n = startTime.length;
            final List<int[]> job = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                job.add(new int[] { startTime[i], endTime[i], profit[i] });
            }
            job.sort(Comparator.comparingInt(a -> a[0]));
            return dfs(job, 0, new Integer[n]);
        }

        public int dfs(List<int[]> job, int start, Integer[] dp) {
            if (start == job.size()) {
                return 0;
            }
            if (dp[start] != null) {
                return dp[start];
            }
            final int skip = dfs(job, start + 1, dp);
            final int take = job.get(start)[2] + dfs(job, lowerBound(job, start), dp);
            return dp[start] = Math.max(take, skip);
        }

        public int lowerBound(List<int[]> job, int i) {
            int lo = i, hi = job.size();
            final int target = job.get(i)[1];
            while (lo < hi) {
                final int mid = lo + hi >>> 1;
                if (job.get(mid)[0] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
}
