package weekly_contests.weekly_134;

import java.util.Arrays;

public class P_1033 {

    public int[] numMovesStones(int a, int b, int c) {
        final int[] stones = { a, b, c };
        Arrays.sort(stones);
        if (stones[2] - stones[0] == 2) {
            return new int[] { 0, 0 };
        }
        final int low = Math.min(stones[1] - stones[0], stones[2] - stones[1]) <= 2 ? 1 : 2;
        final int high = stones[2] - stones[0] - 2;
        return new int[] { low, high };
    }
}
