package leetcode.weekly_contests.weekly_239;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_1850 {

    public int getMinSwaps(String num, int k) {
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            p.add(num.charAt(i) - '0');
        }
        final List<Integer> start = new ArrayList<>(p);
        for (int i = 0; i < k; i++) {
            p = nextPermutation(p);
        }
        int res = 0;
        final int n = p.size();
        while (true) {
            int r = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (!p.get(i).equals(start.get(i))) {
                    r = i;
                    break;
                }
            }
            if (r == -1) {
                break;
            }
            int l = -1;
            for (int i = r; i >= 0; i--) {
                if (p.get(i).equals(start.get(r))) {
                    l = i;
                    break;
                }
            }
            for (int i = l; i < r; i++) {
                Collections.swap(p, i, i + 1);
                res++;
            }
        }
        return res;
    }

    private static List<Integer> nextPermutation(List<Integer> perm) {
        int swapIdx = -1;
        final int n = perm.size();
        for (int i = n - 1; i >= 1; i--) {
            if (perm.get(i - 1) < perm.get(i)) {
                swapIdx = i - 1;
                break;
            }
        }
        if (swapIdx == -1) {
            return Collections.emptyList();
        }
        for (int i = n - 1; i >= 1; i--) {
            if (perm.get(i) > perm.get(swapIdx)) {
                Collections.swap(perm, swapIdx, i);
                break;
            }
        }
        Collections.reverse(perm.subList(swapIdx + 1, perm.size()));
        return perm;
    }
}
