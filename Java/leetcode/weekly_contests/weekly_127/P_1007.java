package leetcode.weekly_contests.weekly_127;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_1007 {

    public int minDominoRotations(int[] A, int[] B) {
        final int l = A[0];
        final int r = B[0];
        final int max = (int) 1e9;
        final int costLU = getCost(A, B, l);
        final int costLD = getCost(B, A, l);
        final int costRU = getCost(A, B, r);
        final int costRD = getCost(B, A, r);
        final int res = Math.min(Math.min(costLD, costLU), Math.min(costRD, costRU));
        return res == max ? -1 : res;
    }

    private static int getCost(int[] up, int[] down, int target) {
        int cost = 0;
        for (int i = 0; i < up.length; i++) {
            if (up[i] == target) {
                continue;
            } else if (down[i] == target) {
                cost += 1;
            } else {
                cost = (int) 1e9;
                break;
            }
        }
        return cost;
    }
}
