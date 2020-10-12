package leetcode.easy;

public class P_172 {

    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    public int trailingZeroes2(int n) {
        long k = 5;
        int res = 0;
        while (k <= n) {
            res += n / k;
            k *= 5;
        }
        return res;
    }
}
