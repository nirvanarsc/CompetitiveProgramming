package leetcode.biweekly_contests.biweekly_0_99.biweekly_46;

public class P_1763 {

    public String longestNiceSubstring(String s) {
        final int n = s.length();
        final int[] ans = { -1, -2 };
        for (int i = 0; i < n; i++) {
            int lowerMask = 0;
            int upperMask = 0;
            for (int j = i; j < n; j++) {
                final char c = s.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    lowerMask |= 1 << (c - 'a');
                } else {
                    upperMask |= 1 << (c - 'A');
                }
                final int diff = Integer.bitCount(lowerMask ^ upperMask);
                if (diff == 0 && j - i > ans[1] - ans[0]) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans[0] == -1 ? "" : s.substring(ans[0], ans[1] + 1);
    }
}
