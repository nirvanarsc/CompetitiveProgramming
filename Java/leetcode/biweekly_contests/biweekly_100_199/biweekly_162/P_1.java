package leetcode.biweekly_contests.biweekly_100_199.biweekly_162;

public class P_1 {

    public int earliestFinishTime(int[] landStartTime,
                                  int[] landDuration,
                                  int[] waterStartTime,
                                  int[] waterDuration) {
        int res = (int) 2e9;
        final int n = landStartTime.length;
        final int m = waterStartTime.length;
        int minEnd = (int) 2e9;
        for (int i = 0; i < n; i++) {
            minEnd = Math.min(minEnd, landStartTime[i] + landDuration[i]);
        }
        for (int i = 0; i < m; i++) {
            res = Math.min(res, waterDuration[i] + Math.max(minEnd, waterStartTime[i]));
        }
        minEnd = (int) 2e9;
        for (int i = 0; i < m; i++) {
            minEnd = Math.min(minEnd, waterStartTime[i] + waterDuration[i]);
        }
        for (int i = 0; i < n; i++) {
            res = Math.min(res, landDuration[i] + Math.max(minEnd, landStartTime[i]));
        }
        return res;
    }
}
