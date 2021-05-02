package leetcode.weekly_contests.weekly_239;

import java.math.BigInteger;

public class P_1849 {

    public boolean splitString(String s) {
        return dfs(s, BigInteger.valueOf(-1));
    }

    private static boolean dfs(String s, BigInteger prev) {
        if (s.isEmpty()) {
            return true;
        }
        if (prev.equals(BigInteger.valueOf(-1))) {
            for (int i = 1; i < s.length(); i++) {
                final BigInteger split = new BigInteger(s.substring(0, i));
                if (dfs(s.substring(i), split)) {
                    return true;
                }
            }
        } else {
            for (int i = 1; i <= s.length(); i++) {
                final BigInteger split = new BigInteger(s.substring(0, i));
                if (split.compareTo(prev) > 0) {
                    break;
                }
                if (prev.subtract(split).equals(BigInteger.ONE)) {
                    if (dfs(s.substring(i), split)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
