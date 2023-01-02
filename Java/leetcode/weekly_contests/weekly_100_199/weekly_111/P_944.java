package leetcode.weekly_contests.weekly_100_199.weekly_111;

public class P_944 {

    public int minDeletionSize(String[] strs) {
        final int n = strs.length;
        final int m = strs[0].length();
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
