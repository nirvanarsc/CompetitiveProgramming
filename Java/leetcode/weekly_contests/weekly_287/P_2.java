package leetcode.weekly_contests.weekly_287;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_2 {

    public List<List<Integer>> findWinners(int[][] matches) {
        final int[] losses = new int[(int) (1e5 + 5)];
        final int[] players = new int[(int) (1e5 + 5)];
        for (int[] p : matches) {
            losses[p[1]]++;
            players[p[0]]++;
            players[p[1]]++;
        }
        final List<Integer> l = new ArrayList<>();
        final List<Integer> r = new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            if (players[i] > 0) {
                if (losses[i] == 0) {
                    l.add(i);
                } else if (losses[i] == 1) {
                    r.add(i);
                }
            }
        }
        return Arrays.asList(l, r);
    }
}
