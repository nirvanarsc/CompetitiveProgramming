package leetcode.weekly_contests.weekly_200_299.weekly_213;

import java.util.Arrays;

public class P_1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        final int[] first = new int[105];
        Arrays.fill(first, -1);
        for (int i = 0; i < pieces.length; i++) {
            first[pieces[i][0]] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            final int idx = first[arr[i]];
            if (idx == -1) {
                return false;
            }
            for (int k = 0; k < pieces[idx].length; k++) {
                if (arr[i++] != pieces[idx][k]) {
                    return false;
                }
            }
            i -= 1;
        }
        return true;
    }
}
