package leetcode.weekly_contests.weekly_400_499.weekly_426;

public class P_1 {

    public int smallestNumber(int n) {
        int res = 1;
        while (res < n) {
            res <<= 1;
            res |= 1;
        }
        return res;
    }
}
