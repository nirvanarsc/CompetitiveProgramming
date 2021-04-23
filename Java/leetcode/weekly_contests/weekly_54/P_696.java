package leetcode.weekly_contests.weekly_54;

public class P_696 {

    public int countBinarySubstrings(String s) {
        final char[] w = s.toCharArray();
        int prev = -1;
        int res = 0;
        for (int i = 0; i < w.length; i++) {
            int j = i;
            while (j < w.length && w[i] == w[j]) {
                j++;
            }
            final int curr = j - i;
            if (prev != -1) {
                res += Math.min(prev, curr);
            }
            prev = curr;
            i = j - 1;
        }
        return res;
    }
}
