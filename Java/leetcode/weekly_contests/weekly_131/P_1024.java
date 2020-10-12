package leetcode.weekly_contests.weekly_131;

import java.util.Arrays;
import java.util.Comparator;

public class P_1024 {

    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, Comparator.comparingInt(a -> a[0]));
        int res = 0;
        for (int i = 0, st = 0, end = 0; st < T; st = end, res++) {
            for (; i < clips.length && clips[i][0] <= st; i++) {
                end = Math.max(end, clips[i][1]);
            }
            if (st == end) {
                return -1;
            }
        }
        return res;
    }
}
