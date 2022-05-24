package leetcode.weekly_contests.weekly_0_99.weekly_48;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P_672 {

    public int flipLights(int n, int m) {
        n = n <= 6 ? n : n % 6 + 6;
        final int flipAll = 0b11111111111 >> (11 - n);
        final int flipOdd = 0b10101010101 >> (11 - n);
        final int flipEven = 0b01010101010 >> (11 - n);
        final int flip3rd = 0b10010010010 >> (11 - n);
        Set<Integer> q = new HashSet<>(Collections.singleton((1 << n) - 1));
        Set<Integer> q2 = new HashSet<>();
        for (int round = 1; round <= m; round++) {
            for (int state : q) {
                q2.add(state ^ flipAll);
                q2.add(state ^ flipOdd);
                q2.add(state ^ flipEven);
                q2.add(state ^ flip3rd);
            }
            q = q2;
            q2 = new HashSet<>();
        }
        return q.size();
    }
}
