package leetcode.biweekly_contests.biweekly_100_199.biweekly_142;

public class P_1 {

    public int possibleStringCount(String word) {
        int res = 1;
        final char[] w = word.toCharArray();
        final int n = w.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && w[i] == w[j]) {
                j++;
            }
            res += j - i - 1;
            i = j - 1;
        }
        return res;
    }
}
