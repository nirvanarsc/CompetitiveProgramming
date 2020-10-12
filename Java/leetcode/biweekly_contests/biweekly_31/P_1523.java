package leetcode.biweekly_contests.biweekly_31;

public class P_1523 {

    public int countOdds(int low, int high) {
        int res = 0;
        if (low % 2 != 0 || high % 2 != 0) {
            res++;
        }
        return ((high - low) >> 1) + res;
    }
}
