package leetcode.weekly_contests.weekly_112;

import java.util.Arrays;

public class P_948 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int curr = 0, res = 0;
        int i = 0, j = tokens.length - 1;
        while (i <= j) {
            int diff = 0;
            while (i <= j && P >= tokens[i]) {
                diff++;
                P -= tokens[i++];
            }
            if (diff == 0) {
                break;
            }
            curr += diff;
            res = Math.max(res, curr);
            P += tokens[j--];
            curr--;
        }
        return res;
    }
}
