package leetcode.weekly_contests.weekly_264;

public class P_2 {

    public int nextBeautifulNumber(int n) {
        n++;
        while (!f(n)) {
            n++;
        }
        return n;
    }

    private static boolean f(int n) {
        final int[] freq = new int[10];
        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0 && i != freq[i]) {
                return false;
            }
        }
        return true;
    }
}
