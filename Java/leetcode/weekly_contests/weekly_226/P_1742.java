package leetcode.weekly_contests.weekly_226;

public class P_1742 {

    public int countBalls(int lowLimit, int highLimit) {
        final int[] freq = new int[100];
        for (int i = lowLimit; i <= highLimit; i++) {
            int curr = 0;
            int num = i;
            while (num > 0) {
                curr += num % 10;
                num /= 10;
            }
            freq[curr]++;
        }
        int res = 0;
        for (int f : freq) {
            res = Math.max(res, f);
        }
        return res;
    }
}
