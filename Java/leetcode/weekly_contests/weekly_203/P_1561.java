package leetcode.weekly_contests.weekly_203;

import java.util.Arrays;

public class P_1561 {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        final int mine = piles.length / 3;
        int res = 0;
        for (int i = piles.length - 2, j = 0; j < mine; i -= 2, j++) {
            res += piles[i];
        }
        return res;
    }
}
