package leetcode.biweekly_contests.biweekly_0_99.biweekly_92;

public class P_1 {

    public int numberOfCuts(int n) {
        if (n == 1) {
            return 0;
        }
        return n % 2 == 0 ? n / 2 : n;
    }
}
