package leetcode.weekly_contests.weekly_100_199.weekly_194;

public class P_1486 {

    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res ^= start + 2 * i;
        }
        return res;
    }
}
