package biweekly_20;

public class P_1359 {

    private static final int MOD = (int) (1e9 + 7);

    public int countOrders(int n) {
        long res = 1;

        for (int t = 2; t <= n; t++) {
            res = (res * (t * (2 * t - 1))) % MOD;
        }

        return (int) res;
    }
}
