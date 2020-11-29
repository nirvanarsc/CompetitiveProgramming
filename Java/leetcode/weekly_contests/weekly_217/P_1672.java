package leetcode.weekly_contests.weekly_217;

public class P_1672 {

    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int[] row: accounts) {
            int curr = 0;
            for (int num: row) {
                curr += num;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
