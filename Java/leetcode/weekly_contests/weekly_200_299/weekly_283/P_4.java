package leetcode.weekly_contests.weekly_200_299.weekly_283;

import java.util.ArrayList;
import java.util.List;

public class P_4 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public List<Integer> replaceNonCoprimes(int[] a) {
        final List<Integer> res = new ArrayList<>();
        for (int num : a) {
            res.add(num);
            while (res.size() > 1 && gcd(res.get(res.size() - 2), res.get(res.size() - 1)) > 1) {
                final int l = res.remove(res.size() - 1);
                final int r = res.remove(res.size() - 1);
                res.add((l / gcd(l, r)) * r);
            }
        }
        return res;
    }
}
