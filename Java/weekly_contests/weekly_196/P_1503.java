package weekly_contests.weekly_196;

import java.util.Arrays;

public class P_1503 {

    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        int res = 0;
        if (left.length > 0) {
            res = Math.max(res, left[left.length - 1]);
        }
        if (right.length > 0) {
            res = Math.max(res, n - right[0]);
        }
        return res;
    }
}
