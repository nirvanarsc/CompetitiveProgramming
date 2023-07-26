package leetcode.weekly_contests.weekly_300_399.weekly_343;

public class P_1 {

    public int isWinner(int[] player1, int[] player2) {
        final int l = f(player1);
        final int r = f(player2);
        if (l == r) {
            return 0;
        }
        return l > r ? 1 : 2;
    }

    private static int f(int[] score) {
        final int n = score.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i >= 2 && score[i - 2] == 10 || i >= 1 && score[i - 1] == 10) {
                res += score[i];
            }
            res += score[i];
        }
        return res;
    }
}
