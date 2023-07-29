package leetcode.weekly_contests.weekly_300_399.weekly_345;

public class P_2 {

    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for (int u : derived) {
            xor ^= u;
        }
        return xor == 0;
    }
}
