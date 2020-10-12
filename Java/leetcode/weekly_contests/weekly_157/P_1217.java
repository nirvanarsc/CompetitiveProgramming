package leetcode.weekly_contests.weekly_157;

public class P_1217 {

    public int minCostToMoveChips(int[] chips) {
        int odd = 0, even = 0;
        for (int chip : chips) {
            if (chip % 2 != 0) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(odd, even);
    }
}
