package leetcode.biweekly_contests.biweekly_0_99.biweekly_70;

public class P_2 {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int currL = lower;
        int currU = upper;
        int diff1 = 0;
        int diff2 = 0;
        for (int diff : differences) {
            currL += diff;
            currU += diff;
            if (currL < lower) {
                diff1 += lower - currL;
                currL = lower;
            }
            if (currU > upper) {
                diff2 += currU - upper;
                currU = upper;
            }
        }
        final int L = lower + diff1;
        final int R = upper - diff2;
        return Math.max(0, R - L + 1);
    }
}
