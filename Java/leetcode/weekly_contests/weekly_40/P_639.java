package leetcode.weekly_contests.weekly_40;

import java.util.Arrays;

public class P_639 {

    private static final int MOD = (int) (1e9 + 7);

    static final int[][] map = new int[58][58];

    static {
        Arrays.fill(map['*'], 1);
        map['*']['*'] = 15;
        map['*']['0'] = 2;
        map['*']['1'] = 2;
        map['*']['2'] = 2;
        map['*']['3'] = 2;
        map['*']['4'] = 2;
        map['*']['5'] = 2;
        map['*']['6'] = 2;
        Arrays.fill(map['1'], 1);
        map['1']['*'] = 9;
        Arrays.fill(map['2'], 1);
        map['2']['*'] = 6;
        map['2']['7'] = 0;
        map['2']['8'] = 0;
        map['2']['9'] = 0;
        Arrays.fill(map[0], 1);
        map[0]['*'] = 9;
        map[0]['0'] = 0;
    }

    public int numDecodingsBottomUp(String s) {
        long cur = map[0][s.charAt(0)], pre = 1;
        for (int i = 1; i < s.length(); i++) {
            final char newC = s.charAt(i);
            final char oldC = s.charAt(i - 1);
            final long next = (map[0][newC] * cur + map[oldC][newC] * pre) % MOD;
            pre = cur;
            cur = next;
        }
        return (int) cur;
    }

    public int numDecodings(String s) {
        return (int) recurse(s, 0, new Long[s.length()]);
    }

    private static long recurse(String s, int start, Long[] dp) {
        if (start == s.length()) {
            return 1;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        long one = 0;
        long two = 0;
        final long nextOne = recurse(s, start + 1, dp);
        if (s.charAt(start) == '*') {
            one = 9 * nextOne;
        } else if (s.charAt(start) != '0') {
            one = nextOne;
        }
        if (start + 2 <= s.length()) {
            final long nextTwo = recurse(s, start + 2, dp);
            if (s.charAt(start) == '*' && s.charAt(start + 1) == '*') {
                two = 15 * nextTwo;
            } else if (s.charAt(start) == '*') {
                two = s.charAt(start + 1) > '6' ? nextTwo : 2 * nextTwo;
            } else if (s.charAt(start + 1) == '*') {
                two = s.charAt(start) == '1' ? 9 * nextTwo
                                             : s.charAt(start) == '2' ? 6 * nextTwo
                                                                      : 0;
            } else {
                final int num = Integer.parseInt(s.substring(start, start + 2));
                if (10 <= num && num <= 26) {
                    two = nextTwo;
                }
            }
        }
        return dp[start] = (one + two) % MOD;
    }
}
