package leetcode.weekly_contests.weekly_300_399.weekly_348;

public class P_1 {

    public int minimizedStringLength(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            mask |= 1 << (c - 'a');
        }
        return Integer.bitCount(mask);
    }
}
