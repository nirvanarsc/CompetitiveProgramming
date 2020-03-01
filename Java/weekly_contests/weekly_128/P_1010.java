package weekly_contests.weekly_128;

public class P_1010 {

    public int numPairsDivisibleBy60(int[] time) {
        final int[] remainders = new int[60];
        for (int t : time) {
            remainders[t % 60]++;
        }
        int res = 0;
        for (int i = 0; i <= remainders.length / 2; i++) {
            if (i == 0 || i == 30) {
                res += (remainders[i] * (remainders[i] - 1)) / 2;
            } else {
                res += remainders[i] * remainders[60 - i];
            }
        }
        return res;
    }
}
