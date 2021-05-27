package binarysearch.weekly_38;

import java.util.TreeSet;

public class P_3 {

    public int solve(int[] a, int[] b, int[] c) {
        final TreeSet<Integer> aa = new TreeSet<>();
        final TreeSet<Integer> cc = new TreeSet<>();
        for (int num : a) {
            aa.add(num);
        }
        for (int num : c) {
            cc.add(num);
        }
        int res = (int) 2e9;
        for (int num : b) {
            final Integer loA = aa.floor(num);
            final Integer hiA = aa.ceiling(num);

            final Integer loC = cc.floor(num);
            final Integer hiC = cc.ceiling(num);

            if (loA != null && loC != null) {
                res = Math.min(res, 2 * num - (loA + loC));
            }
            if (loA != null && hiC != null) {
                res = Math.min(res, hiC - loA);
            }
            if (hiA != null && loC != null) {
                res = Math.min(res, hiA - loC);
            }
            if (hiA != null && hiC != null) {
                res = Math.min(res, (hiA + hiC) - 2 * num);
            }
        }
        return res;
    }
}
