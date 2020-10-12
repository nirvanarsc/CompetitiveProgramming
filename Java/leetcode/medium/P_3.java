package leetcode.medium;

import java.util.Arrays;

public class P_3 {

    public int lengthOfLongestSubstringSlidingWindow(String s) {
        final int[] map = new int[128];
        int j = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            while (map[s.charAt(i)] > 1) {
                map[s.charAt(j++)]--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        final int[] map = new int[256];
        Arrays.fill(map, -1);
        int res = 0, start = 0, i = 0;
        for (; i < s.length(); i++) {
            if (map[s.charAt(i)] != -1) {
                res = Math.max(res, i - start);
                start = Math.max(start, map[s.charAt(i)] + 1);
            }
            map[s.charAt(i)] = i;
        }
        res = Math.max(res, i - start);
        return res;
    }
}
