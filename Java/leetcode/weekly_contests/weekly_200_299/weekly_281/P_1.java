package leetcode.weekly_contests.weekly_200_299.weekly_281;

public class P_1 {

    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            if (f(i) % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    private static int f(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
