package leetcode.weekly_contests.weekly_0_99.weekly_56;

public class P_443 {

    public int compress(char[] chars) {
        final int n = chars.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            int k = i;
            while (k < n && chars[i] == chars[k]) {
                k++;
            }
            chars[j++] = chars[i];
            if (k - i > 1) {
                final String c = String.valueOf(k - i);
                for (int l = 0; l < c.length(); l++) {
                    chars[j++] = c.charAt(l);
                }
            }
            i = k - 1;
        }
        return j;
    }
}
