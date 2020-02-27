package weekly_contests.weekly_136;

import java.util.Arrays;

public class P_1041 {

    public boolean isRobotBounded(String instructions) {
        final int[] cycle = { 0, 0 };
        final int[] pos = { 0, 0 };
        int dir = 0;
        for (int k = 0; k < 4; k++) {
            for (char c : instructions.toCharArray()) {
                if (c == 'G') {
                    switch (dir) {
                        case 0: pos[1]++; break;
                        case 1: pos[0]++; break;
                        case 2: pos[1]--; break;
                        case 3: pos[0]--; break;
                    }
                } else if (c == 'L') {
                    dir = ((dir - 1) + 4) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
        }
        return Arrays.equals(pos, cycle);
    }
}
