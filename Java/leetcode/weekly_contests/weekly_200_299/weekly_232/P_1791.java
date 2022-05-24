package leetcode.weekly_contests.weekly_200_299.weekly_232;

public class P_1791 {

    public int findCenter(int[][] edges) {
        final int[] deg = new int[(int) (1e5 + 5)];
        for (int[] e : edges) {
            deg[e[0]]++;
            deg[e[1]]++;
        }
        int best = 0;
        int res = -1;
        for (int i = 0; i < deg.length; i++) {
            if (best < deg[i]) {
                best = deg[i];
                res = i;
            }
        }
        return res;
    }
}
