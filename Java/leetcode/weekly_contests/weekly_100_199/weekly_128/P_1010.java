package leetcode.weekly_contests.weekly_100_199.weekly_128;

public class P_1010 {

    public int numPairsDivisibleBy60(int[] time) {
        final int[] r = new int[60];
        int res = 0;
        for (int num : time) {
            num %= 60;
            res += r[(60 - num) % 60];
            r[num]++;
        }
        return res;
    }

    public int numPairsDivisibleBy60Old(int[] time) {
        final int[] rem = new int[60];
        for (int t : time) {
            rem[t % 60]++;
        }
        int res = 0;
        res += (rem[0] * (rem[0] - 1)) / 2;
        res += (rem[30] * (rem[30] - 1)) / 2;
        int lo = 1;
        int hi = 59;
        while (lo < hi) {
            res += rem[lo++] * rem[hi--];
        }
        return res;
    }
}
