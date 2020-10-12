package leetcode.weekly_contests.weekly_20;

import java.util.Arrays;

public class P_517 {

    public int findMinMoves(int[] machines) {
        final int sum = Arrays.stream(machines).sum();
        final int k = sum / machines.length;
        if (k * machines.length != sum) {
            return -1;
        }
        int maxOffload = 0;
        int maxDiff = 0;
        int currSum = 0;
        for (int m : machines) {
            maxOffload = Math.max(maxOffload, m - k);
            currSum += m - k;
            maxDiff = Math.max(maxDiff, Math.abs(currSum));
        }
        return Math.max(maxOffload, maxDiff);
    }
}
