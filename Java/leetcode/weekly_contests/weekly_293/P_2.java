package leetcode.weekly_contests.weekly_293;

import java.util.Arrays;

public class P_2 {

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int curr = bottom - 1;
        int res = 0;
        for (int num : special) {
            res = Math.max(res, num - curr - 1);
            curr = num;
        }
        res = Math.max(res, top - curr);
        return res;
    }
}
