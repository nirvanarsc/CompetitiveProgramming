package weekly_contests.weekly_182;

import java.util.Arrays;

public class P_1395 {

    public int numTeams(int[] rating) {
        final int n = rating.length;
        final int k = 3;
        final int[][] increasing = new int[k][n];
        final int[][] decreasing = new int[k][n];
        int sum = 0;
        Arrays.fill(increasing[0], 1);
        Arrays.fill(decreasing[0], 1);
        for (int l = 1; l < k; l++) {
            for (int i = l; i < n; i++) {
                for (int j = l - 1; j < i; j++) {
                    if (rating[j] < rating[i]) {
                        increasing[l][i] += increasing[l - 1][j];
                    }
                    if (rating[j] > rating[i]) {
                        decreasing[l][i] += decreasing[l - 1][j];
                    }
                }
            }
        }
        for (int i = k - 1; i < n; i++) {
            sum += increasing[k - 1][i];
            sum += decreasing[k - 1][i];
        }
        return sum;
    }
}
