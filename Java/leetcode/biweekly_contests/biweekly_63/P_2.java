package leetcode.biweekly_contests.biweekly_63;

public class P_2 {

    public boolean winnerOfGame(String colors) {
        int a = 0;
        int b = 0;
        final int n = colors.length();
        final char[] w = colors.toCharArray();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && w[j] == w[i]) {
                j++;
            }
            final int L = j - i;
            if (w[i] == 'A') {
                a += Math.max(0, L - 2);
            } else {
                b += Math.max(0, L - 2);
            }
            i = j - 1;
        }
        return a > b;
    }
}
