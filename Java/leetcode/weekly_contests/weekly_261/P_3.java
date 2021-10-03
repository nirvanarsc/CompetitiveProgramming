package leetcode.weekly_contests.weekly_261;

public class P_3 {

    public boolean stoneGameIX(int[] stones) {
        final int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        if (Math.min(count[1], count[2]) == 0) {
            return Math.max(count[1], count[2]) > 2 && count[0] % 2 > 0;
        }
        return Math.abs(count[1] - count[2]) > 2 || count[0] % 2 == 0;
    }
}
