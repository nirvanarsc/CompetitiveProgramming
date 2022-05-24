package leetcode.weekly_contests.weekly_200_299.weekly_214;

import java.util.Arrays;

public class P_1648 {

    private static final int MOD = (int) (1e9 + 7);

    public int maxProfit(int[] inventory, int orders) {
        long res = 0, colors = 1;
        Arrays.sort(inventory);
        final int n = inventory.length;
        for (int i = n - 1; i >= 0 && orders > 0; i--, colors++) {
            final long curr = inventory[i];
            final long prev = i > 0 ? inventory[i - 1] : 0;
            final long rounds = Math.min(orders / colors, curr - prev);
            orders -= rounds * colors;
            res = (res + (curr * (curr + 1) - (curr - rounds) * (curr - rounds + 1)) / 2 * colors) % MOD;
            System.out.println(orders + " " + res);
            if (curr - prev > rounds) {
                res = (res + orders * (curr - rounds)) % MOD;
                break;
            }
        }
        return (int) res;
    }
}
