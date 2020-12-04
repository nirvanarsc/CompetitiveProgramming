package leetcode.biweekly_contests.biweekly_29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_1492 {

    public int kthFactor(int n, int k) {
        final List<Integer> lower = new ArrayList<>();
        final List<Integer> higher = new ArrayList<>();
        for (int p = 1; p * p <= n; p++) {
            if (n % p == 0) {
                if (n != p * p) {
                    higher.add(n / p);
                }
                lower.add(p);
            }
        }
        Collections.reverse(higher);
        k -= 1;
        if (k < lower.size()) {
            return lower.get(k);
        }
        k -= lower.size();
        if (k < higher.size()) {
            return higher.get(k);
        }
        return -1;
    }
}
