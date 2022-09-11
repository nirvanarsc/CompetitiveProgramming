package leetcode.weekly_contests.weekly_300_399.weekly_310;

public class P_2 {

    public int partitionString(String s) {
        final char[] w = s.toCharArray();
        int res = 1;
        int mask = 0;
        for (char c : w) {
            if ((mask & (1 << (c - 'a'))) != 0) {
                mask = 0;
                res++;
            }
            mask |= 1 << (c - 'a');
        }
        return res;
    }
}
