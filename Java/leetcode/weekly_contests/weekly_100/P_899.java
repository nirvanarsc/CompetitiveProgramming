package leetcode.weekly_contests.weekly_100;

import java.util.Arrays;

public class P_899 {

    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            final char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        String res = s;
        for (int i = 1; i < s.length(); i++) {
            final String tmp = s.substring(i) + s.substring(0, i);
            if (res.compareTo(tmp) > 0) {
                res = tmp;
            }
        }
        return res;
    }
}
