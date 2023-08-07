package leetcode.biweekly_contests.biweekly_100_199.biweekly_110;

public class P_1 {

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int res = 100 - ((purchaseAmount + 9) / 10) * 10;
        if (purchaseAmount % 10 > 0 && purchaseAmount % 10 < 5) {
            res += 10;
        }
        return res;
    }
}
