package leetcode.weekly_contests.weekly_238;

public class P_1837 {

    public int sumBase(int n, int k) {
        int res = 0;
        while (n > 0) {
            res += n % k;
            n /= k;
        }
        return res;
    }
}
