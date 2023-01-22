package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class P_131 {

    public List<List<String>> partition(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length - 1;
        final StringBuilder sb = new StringBuilder();
        final List<String> curr = new ArrayList<>();
        final List<List<String>> res = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            sb.append(w[0]);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr.add(sb.toString());
                    sb.setLength(0);
                }
                sb.append(w[i + 1]);
            }
            curr.add(sb.toString());
            sb.setLength(0);
            boolean ok = true;
            for (String c : curr) {
                if (!isPalindrome(c.toCharArray())) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                res.add(new ArrayList<>(curr));
            }
            curr.clear();
        }
        return res;
    }

    private static boolean isPalindrome(char[] w) {
        int l = 0;
        int r = w.length - 1;
        while (l < r) {
            if (w[l++] != w[r--]) {
                return false;
            }
        }
        return true;
    }
}
