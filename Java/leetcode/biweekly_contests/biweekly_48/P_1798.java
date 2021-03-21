package leetcode.biweekly_contests.biweekly_48;

import java.util.Arrays;

public class P_1798 {

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int max = 0;
        for (int c : coins) {
            if (c > max + 1) {
                break;
            }
            max += c;
        }
        return max + 1;
    }
}
