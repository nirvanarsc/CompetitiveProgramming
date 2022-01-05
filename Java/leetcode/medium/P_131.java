package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class P_131 {

    public List<List<String>> partition(String s) {
        final List<List<String>> res = new ArrayList<>();
        dfs(0, s, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(int start, String s, List<String> curr, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (isPalindrome(s, start, i - 1)) {
                curr.add(s.substring(start, i));
                dfs(i, s, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public List<List<String>> partitionMasks(String s) {
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
