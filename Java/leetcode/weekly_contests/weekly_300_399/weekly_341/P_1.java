package leetcode.weekly_contests.weekly_300_399.weekly_341;

public class P_1 {

    public int[] rowAndMaximumOnes(int[][] mat) {
        final int[] res = { -1, -1 };
        final int n = mat.length;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int num : mat[i]) {
                curr += num;
            }
            if (res[1] < curr) {
                res[0] = i;
                res[1] = curr;
            }
        }
        return res;
    }
}
