package leetcode.biweekly_contests.biweekly_100_199.biweekly_155;

import java.util.ArrayList;
import java.util.List;

public class P_3 {

    public int countCells(char[][] grid, String pattern) {
        final int[] lps = computeLPSArray(pattern);
        final int n = grid.length;
        final int m = grid[0].length;
        final int k = pattern.length();
        final StringBuilder horizontal = new StringBuilder();
        final StringBuilder vertical = new StringBuilder();
        for (char[] row : grid) {
            for (int j = 0; j < m; j++) {
                horizontal.append(row[j]);
            }
        }
        for (int j = 0; j < m; j++) {
            for (char[] row : grid) {
                vertical.append(row[j]);
            }
        }
        final List<Integer> h = kmpSearch(horizontal.toString(), pattern, lps);
        final List<Integer> v = kmpSearch(vertical.toString(), pattern, lps);
        final int[] map = apply(n, m, h, k);
        final int[] map2 = apply(n, m, v, k);
        int res = 0;
        for (int i = 0; i < n * m; i++) {
            final int r = i / n;
            final int c = i % n;
            if (map[c * m + r] > 0 && map2[i] > 0) {
                res++;
            }
        }
        return res;
    }

    private static int[] apply(int n, int m, List<Integer> h, int k) {
        final int[] map = new int[n * m + 1];
        for (int u : h) {
            map[u]++;
            map[u + k]--;
        }
        int curr = 0;
        for (int i = 0; i < n * m; i++) {
            curr += map[i];
            map[i] = curr;
        }
        return map;
    }

    private static List<Integer> kmpSearch(String text, String pattern, int[] lps) {
        final List<Integer> indices = new ArrayList<>();
        int i = 0, j = 0;
        final int n = text.length();
        final int m = pattern.length();
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                indices.add(i - j);
                j = lps[j - 1];
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return indices;
    }

    private static int[] computeLPSArray(String pattern) {
        final int n = pattern.length();
        final int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }
}
