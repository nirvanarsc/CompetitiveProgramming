package leetcode.biweekly_contests.biweekly_0_99.biweekly_83;

public class P_1 {

    public String bestHand(int[] ranks, char[] suits) {
        final char d = suits[0];
        boolean flush = true;
        for (char c : suits) {
            if (c != d) {
                flush = false;
                break;
            }
        }
        if (flush) {
            return "Flush";
        }
        final int[] f = new int[20];
        for (int r : ranks) {
            f[r]++;
        }
        int max = 0;
        for (int freq : f) {
            max = Math.max(max, freq);
        }
        if (max >= 3) {
            return "Three of a Kind";
        }
        if (max == 2) {
            return "Pair";
        }
        return "High Card";
    }
}
