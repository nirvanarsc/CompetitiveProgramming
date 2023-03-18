package leetcode.biweekly_contests.biweekly_0_99.biweekly_41;

import java.util.ArrayList;
import java.util.List;

public class P_1686 {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        final int n = aliceValues.length;
        final List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new int[] { aliceValues[i], bobValues[i] });
        }
        pairs.sort((a, b) -> Integer.compare(b[0] + b[1], a[0] + a[1]));
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                alice += pairs.get(i)[0];
            } else {
                bob += pairs.get(i)[1];
            }
        }
        return Integer.compare(alice, bob);
    }
}
