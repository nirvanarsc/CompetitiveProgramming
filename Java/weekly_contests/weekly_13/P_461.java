package weekly_contests.weekly_13;

public class P_461 {

    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int res = 0;
        while (n > 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }
}
