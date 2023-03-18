package leetcode.biweekly_contests.biweekly_0_99.biweekly_66;

public class P_3 {

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int res = 0;
        for (int i = startPos[0]; i < homePos[0]; i++) {
            res += rowCosts[i + 1];
        }
        for (int i = startPos[0]; i > homePos[0]; i--) {
            res += rowCosts[i - 1];
        }
        for (int i = startPos[1]; i < homePos[1]; i++) {
            res += colCosts[i + 1];
        }
        for (int i = startPos[1]; i > homePos[1]; i--) {
            res += colCosts[i - 1];
        }
        return res;
    }
}
