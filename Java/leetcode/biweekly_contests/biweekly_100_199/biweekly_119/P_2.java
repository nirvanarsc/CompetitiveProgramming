package leetcode.biweekly_contests.biweekly_100_199.biweekly_119;

public class P_2 {

    public int removeAlmostEqualCharacters(String word) {
        final char[] w = word.toCharArray();
        final int n = w.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(w[i] - w[i + 1]) < 2) {
                res++;
                i++;
            }
        }
        return res;
    }
}
