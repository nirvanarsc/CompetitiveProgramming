package leetcode.weekly_contests.weekly_109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_936 {

    public int[] movesToStamp(String stamp, String target) {
        final List<Integer> res = new ArrayList<>();
        final char[] end = new char[target.length()];
        Arrays.fill(end, '?');
        final boolean ok = dfs(stamp.toCharArray(), target.toCharArray(), end, res);
        if (!ok) {
            //noinspection ZeroLengthArrayAllocation
            return new int[0];
        }
        final int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(res.size() - 1 - i);
        }
        return ret;
    }

    private static boolean dfs(char[] s, char[] t, char[] end, List<Integer> res) {
        if (Arrays.equals(t, end)) {
            return true;
        }
        for (int i = 0; i < t.length - s.length + 1; i++) {
            if (match(s, t, i)) {
                res.add(i);
                for (int j = 0; j < s.length; j++) {
                    t[i + j] = '?';
                }
                //noinspection TailRecursion
                return dfs(s, t, end, res);
            }
        }
        return false;
    }

    private static boolean match(char[] s, char[] t, int j) {
        boolean ok = false;
        for (int i = 0; i < s.length; i++) {
            if (t[i + j] != '?' && t[i + j] != s[i]) {
                return false;
            }
            ok |= t[i + j] != '?';
        }
        return ok;
    }
}
