package leetcode.weekly_contests.weekly_300_399.weekly_333;

public class P_2 {

    public int minOperations(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 3) == 3) {
                res++;
                n++;
            }
            if ((n & 1) != 0) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }
}
