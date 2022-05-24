package leetcode.weekly_contests.weekly_100_199.weekly_168;

import java.util.HashMap;
import java.util.Map;

public final class P_1296 {

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        final Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i <= s.length() - minSize; i++) {
            final String curr = s.substring(i, i + minSize);
            int f = 0;
            for (char c : curr.toCharArray()) {
                f |= 1 << c;
            }
            if (Integer.bitCount(f) <= maxLetters) {
                map.merge(curr, 1, Integer::sum);
            }
        }
        for (int v : map.values()) {
            res = Math.max(res, v);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxFreq("aababcaab", 2, 3, 4));
        System.out.println(maxFreq("aaaa", 1, 3, 3));
        System.out.println(maxFreq("aabcabcab", 2, 2, 3));
        System.out.println(maxFreq("abcde", 2, 3, 3));
    }

    private P_1296() {}
}
