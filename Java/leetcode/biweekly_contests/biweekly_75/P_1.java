package leetcode.biweekly_contests.biweekly_75;

public class P_1 {

    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
