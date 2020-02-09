package weekly_175;

import java.util.LinkedList;
import java.util.List;

public class P_1349 {

    public int maxStudents(char[][] seats) {
        return getMax(seats, 0, 0, new Integer[seats.length][1 << seats[0].length]);
    }

    private static int getMax(char[][] seats, int curRow, int mask, Integer[][] dp) {
        if (curRow == seats.length) {
            return 0;
        }
        if (dp[curRow][mask] != null) {
            return dp[curRow][mask];
        }
        final List<Integer> masks = new LinkedList<>();
        backtrack(seats[curRow], 0, mask, 0, masks, seats.length);
        int res = 0;
        for (int m : masks) {
            res = Math.max(res, Integer.bitCount(m) + getMax(seats, curRow + 1, m, dp));
        }
        return dp[curRow][mask] = res;
    }

    private static void backtrack(char[] seats, int cur, int prev, int mask, List<Integer> masks, int r) {
        if (cur == seats.length) {
            masks.add(mask);
            return;
        }
        if (seats[cur] == '#') {
            backtrack(seats, cur + 1, prev, mask, masks, r);
            return;
        }
        if (cur > 0 && (((mask & (1 << (cur - 1))) > 0) || (prev & (1 << (cur - 1))) > 0)) {
            backtrack(seats, cur + 1, prev, mask, masks, r);
        } else if (cur < r - 1 && ((prev & (1 << (cur + 1))) > 0)) {
            backtrack(seats, cur + 1, prev, mask, masks, r);
        } else {
            mask |= 1 << cur;
            backtrack(seats, cur + 1, prev, mask, masks, r);
            mask ^= 1 << cur;
            backtrack(seats, cur + 1, prev, mask, masks, r);
        }
    }
}
