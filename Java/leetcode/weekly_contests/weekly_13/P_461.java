package leetcode.weekly_contests.weekly_13;

public class P_461 {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        while (xor > 0) {
            xor &= xor - 1;
            res++;
        }
        return res;
    }
}
