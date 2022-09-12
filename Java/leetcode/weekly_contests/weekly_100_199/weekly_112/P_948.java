package leetcode.weekly_contests.weekly_100_199.weekly_112;

import java.util.Arrays;

public class P_948 {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        final int n = tokens.length;
        int i = 0;
        int j = n - 1;
        int curr = 0;
        int res = 0;
        while (i <= j && curr >= 0) {
            while (i <= j && tokens[i] <= power) {
                curr++;
                power -= tokens[i++];
            }
            res = Math.max(res, curr);
            power += tokens[j--];
            curr--;
        }
        return res;
    }
}
