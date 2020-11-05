package leetcode.weekly_contests.weekly_157;

public class P_1217 {

    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int num : position) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }
}
