package leetcode.weekly_contests.weekly_0_99.weekly_3;

public class P_395 {

    public int longestSubstring(String s, int k) {
        int res = 0;
        final char[] chars = s.toCharArray();
        for (int window = 1; window <= 26 && window * k <= s.length(); window++) {
            res = Math.max(res, check(chars, k, window, window));
        }
        return res;
    }

    private static int check(char[] s, int k, int uniq, int uniqK) {
        final int[] count = new int[26];
        int j = 0;
        int res = 0;
        for (int i = 0; i < s.length; i++) {
            if (count[s[i] - 'a']++ == 0) { uniq--; }
            if (count[s[i] - 'a'] == k) { uniqK--; }
            while (uniq < 0) {
                if (count[s[j] - 'a'] == k) { uniqK++; }
                if (--count[s[j++] - 'a'] == 0) { uniq++; }
            }
            if (uniq == 0 && uniqK == 0) {
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}
