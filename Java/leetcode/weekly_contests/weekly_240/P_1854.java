package leetcode.weekly_contests.weekly_240;

public class P_1854 {

    public int maximumPopulation(int[][] logs) {
        final int[] f = new int[2100];
        for (int[] l : logs) {
            f[l[0]]++;
            f[l[1]]--;
        }
        int curr = 0;
        final int max = 0;
        int res = -1;
        for (int i = 0; i < f.length; i++) {
            curr += f[i];
            if (curr > max) {
                curr = max;
                res = i;
            }
        }
        return res;
    }
}
