package leetcode.biweekly_contests.biweekly_95;

public class P_1 {

    public String categorizeBox(int length, int width, int height, int mass) {
        final String[] res = { "Neither", "Bulky", "Heavy", "Both" };
        int mask = 0;
        if (mass >= 100) {
            mask |= 2;
        }
        if (length >= (int) 1e4 || width >= (int) 1e4 || height >= (int) 1e4) {
            mask |= 1;
        }
        final long volume = (long) length * width * height;
        if (volume >= (int) 1e9) {
            mask |= 1;
        }
        return res[mask];
    }
}
