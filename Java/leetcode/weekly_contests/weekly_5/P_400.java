package leetcode.weekly_contests.weekly_5;

public class P_400 {

    public int findNthDigit(int n) {
        int len = 1, i = 1;
        long range = 9;
        while (n > len * range) {
            n -= len * range;
            len++;
            range *= 10;
            i *= 10;
        }
        i += (n - 1) / len;
        return Character.getNumericValue(Integer.toString(i).charAt((n - 1) % len));
    }
}
