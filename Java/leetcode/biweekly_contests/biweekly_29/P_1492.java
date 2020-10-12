package leetcode.biweekly_contests.biweekly_29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_1492 {

    public int kthFactor(int n, int k) {
        final List<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                if (i * i != n) {
                    factors.add(n / i);
                }
            }
        }
        Collections.sort(factors);
        return k > factors.size() ? -1 : factors.get(k - 1);
    }
}
