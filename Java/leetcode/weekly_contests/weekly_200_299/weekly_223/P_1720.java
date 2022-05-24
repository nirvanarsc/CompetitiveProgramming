package leetcode.weekly_contests.weekly_200_299.weekly_223;

public class P_1720 {

    public int[] decode(int[] encoded, int first) {
        final int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 1; i < res.length; i++) {
            first ^= encoded[i - 1];
            res[i] = first;
        }
        return res;
    }
}
