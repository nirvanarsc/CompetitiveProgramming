package leetcode.weekly_contests.weekly_300_399.weekly_334;

public class P_2 {

    public int[] divisibilityArray(String word, int m) {
        final int n = word.length();
        long curr = 0;
        final int[] res = new int[n];
        final char[] w = word.toCharArray();
        for (int i = 0; i < n; i++) {
            curr = (curr * 10 + w[i] - '0') % m;
            res[i] = curr == 0 ? 1 : 0;
        }
        return res;
    }
}
