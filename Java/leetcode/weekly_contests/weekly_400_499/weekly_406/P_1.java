package leetcode.weekly_contests.weekly_400_499.weekly_406;

public class P_1 {

    public String getSmallestString(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        for (int i = 0; i < n - 1; i++) {
            if ((w[i] - '0') % 2 == (w[i + 1] - '0') % 2) {
                if (w[i] > w[i + 1]) {
                    final char c = w[i];
                    w[i] = w[i + 1];
                    w[i + 1] = c;
                    break;
                }
            }
        }
        return new String(w);
    }
}
