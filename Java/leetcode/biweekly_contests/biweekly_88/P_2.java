package leetcode.biweekly_contests.biweekly_88;

import java.util.Arrays;

public class P_2 {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0;
        final int n = players.length;
        for (int t : trainers) {
            if (i < n && t >= players[i]) {
                i++;
            }
        }
        return i;
    }
}
