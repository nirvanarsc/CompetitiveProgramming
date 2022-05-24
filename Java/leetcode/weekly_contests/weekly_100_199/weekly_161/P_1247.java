package leetcode.weekly_contests.weekly_100_199.weekly_161;

public class P_1247 {

    public int minimumSwap(String s1, String s2) {
        int xy = 0, yx = 0;
        final char[] c1 = s1.toCharArray();
        final char[] c2 = s2.toCharArray();
        for (int i = 0; i < c1.length; ++i) {
            if (c1[i] != c2[i]) {
                if (c1[i] == 'x') {
                    xy++;
                } else {
                    yx++;
                }
            }
        }
        return (xy + yx) % 2 != 0 ? -1 : xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }
}
