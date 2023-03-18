package leetcode.biweekly_contests.biweekly_100_199.biweekly_100;

public class P_1 {

    public int distMoney(int money, int children) {
        for (int u = Math.min(children, money / 8); u >= 0; u--) {
            final int v = money - u * 8;
            final int k = children - u;
            if (v == 4 && k == 1 || (v < k) || (v > 0 && k == 0)) {
                continue;
            }
            return u;
        }
        return -1;
    }
}
