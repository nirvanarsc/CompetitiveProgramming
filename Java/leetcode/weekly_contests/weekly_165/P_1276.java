package leetcode.weekly_contests.weekly_165;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_1276 {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices < 2 * cheeseSlices || tomatoSlices > 4 * cheeseSlices || (tomatoSlices & 1) == 1) {
            return Collections.emptyList();
        }

        final int J = (tomatoSlices - (2 * cheeseSlices)) / 2;
        final int S = cheeseSlices - J;

        return Arrays.asList(J, S);
    }
}
