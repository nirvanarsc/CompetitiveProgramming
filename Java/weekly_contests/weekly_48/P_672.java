package weekly_contests.weekly_48;

import java.util.HashSet;
import java.util.Set;

public class P_672 {

    @SuppressWarnings("PointlessBitwiseExpression")
    public int flipLights(int n, int m) {
        final Set<Integer> seen = new HashSet<>();
        n = Math.min(n, 6);
        final int shift = Math.max(0, 6 - n);
        for (int candidate = 0; candidate < 16; ++candidate) {
            final int bits = Integer.bitCount(candidate);
            if (bits % 2 == m % 2 && bits <= m) {
                int lights = 0;
                if (((candidate >> 0) & 1) > 0) { lights ^= 0b111111 >> shift; }
                if (((candidate >> 1) & 1) > 0) { lights ^= 0b010101 >> shift; }
                if (((candidate >> 2) & 1) > 0) { lights ^= 0b101010 >> shift; }
                if (((candidate >> 3) & 1) > 0) { lights ^= 0b100100 >> shift; }
                seen.add(lights);
            }
        }
        return seen.size();
    }
}
