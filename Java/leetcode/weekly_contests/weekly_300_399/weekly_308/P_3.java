package leetcode.weekly_contests.weekly_300_399.weekly_308;

public class P_3 {

    public int garbageCollection(String[] garbage, int[] travel) {
        final int n = garbage.length;
        final int[][] f = new int[n][3];
        final int[] last = new int[3];
        for (int i = 0; i < n; i++) {
            for (char w : garbage[i].toCharArray()) {
                if (w == 'M') {
                    last[0] = i;
                    f[i][0]++;
                } else if (w == 'P') {
                    last[1] = i;
                    f[i][1]++;
                } else {
                    last[2] = i;
                    f[i][2]++;
                }
            }
        }
        int res = 0;
        for (int t = 0; t < 3; t++) {
            for (int i = 0; i < n; i++) {
                res += f[i][t];
                if (last[t] == i) {
                    break;
                }
                res += travel[i];
            }
        }
        return res;
    }
}
