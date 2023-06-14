package leetcode.weekly_contests.weekly_300_399.weekly_341;

public class P_3 {

    public int addMinimum(String word) {
        final char[] w = word.toCharArray();
        final int n = w.length;
        final String match = "abc";
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < n) {
            if (w[i] == match.charAt(j % 3)) {
                i++;
            } else {
                res++;
            }
            j++;
        }
        return res + (j % 3 == 0 ? 0 : (3 - (j % 3)));
    }
}
