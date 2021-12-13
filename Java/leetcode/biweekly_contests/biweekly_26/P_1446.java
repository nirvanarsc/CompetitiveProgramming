package leetcode.biweekly_contests.biweekly_26;

public class P_1446 {

    public int maxPower(String s) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && w[j] == w[i]) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j - 1;
        }
        return res;
    }
}
