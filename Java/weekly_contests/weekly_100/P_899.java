package weekly_contests.weekly_100;

import java.util.Arrays;

public class P_899 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public String orderlyQueue(String S, int K) {
        if (K > 1) {
            final char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        String res = S;
        for (int i = 1; i < S.length(); i++) {
            final String tmp = S.substring(i) + S.substring(0, i);
            if (res.compareTo(tmp) > 0) {
                res = tmp;
            }
        }
        return res;
    }
}
