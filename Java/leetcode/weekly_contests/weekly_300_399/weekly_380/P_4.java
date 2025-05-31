package leetcode.weekly_contests.weekly_300_399.weekly_380;

import java.util.ArrayList;
import java.util.List;

public class P_4 {

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        final List<Integer> aIndices = kmpSearch(s, a);
        final List<Integer> bIndices = kmpSearch(s, b);
        final List<Integer> result = new ArrayList<>();
        for (int idxA : aIndices) {
            final int pos = lowerBound(bIndices, idxA - k);
            if (pos < bIndices.size() && Math.abs(bIndices.get(pos) - idxA) <= k) {
                result.add(idxA);
            }
        }
        return result;
    }

    private static List<Integer> kmpSearch(String text, String pattern) {
        final List<Integer> indices = new ArrayList<>();
        final int[] lps = computeLPSArray(pattern);
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

    private static int lowerBound(List<Integer> list, int value) {
        int lo = 0;
        int hi = list.size();
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (list.get(mid) < value) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
