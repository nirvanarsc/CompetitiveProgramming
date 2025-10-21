package leetcode.biweekly_contests.biweekly_100_199.biweekly_143;

public class P_1 {

    public int smallestNumber(int n, int t) {
        while (f(n) % t != 0) {
            n++;
        }
        return n;
    }

    private static int f(int n) {
        int p = 1;
        while (n > 0) {
            p *= n % 10;
            n /= 10;
        }
        return p;
    }
}
