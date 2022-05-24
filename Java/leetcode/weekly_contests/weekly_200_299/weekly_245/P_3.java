package leetcode.weekly_contests.weekly_200_299.weekly_245;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P_3 {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        final List<int[]> collect = Arrays
                .stream(triplets)
                .filter(x -> x[0] <= target[0] && x[1] <= target[1] && x[2] <= target[2])
                .collect(Collectors.toList());
        int mask = 0;
        for (int[] ok : collect) {
            if (ok[0] == target[0]) {
                mask |= 1;
            }
            if (ok[1] == target[1]) {
                mask |= 1 << 1;
            }
            if (ok[2] == target[2]) {
                mask |= 1 << 2;
            }
        }
        return mask == 7;
    }
}
