package leetcode.weekly_contests.weekly_3;

public class P_395 {

    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int i = 1; i <= 26; i++) {
            res = Math.max(res, longest(s, i, k));
        }
        return res;
    }

    private static int longest(String s, int uniques, int k) {
        final int[] map = new int[128];
        int j = 0;
        int currUniques = 0;
        int currAtLeastK = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]++ == 0) { currUniques++; }
            if (map[s.charAt(i)] == k) { currAtLeastK++; }

            while (currUniques > uniques) {
                if (map[s.charAt(j)]-- == k) { currAtLeastK--; }
                if (map[s.charAt(j)] == 0) { currUniques--; }
                j++;
            }

            if (currUniques == uniques && currAtLeastK == uniques) {
                res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }
}
