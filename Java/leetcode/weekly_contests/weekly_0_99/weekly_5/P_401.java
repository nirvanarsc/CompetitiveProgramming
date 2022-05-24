package leetcode.weekly_contests.weekly_0_99.weekly_5;

import java.util.ArrayList;
import java.util.List;

public class P_401 {

    public List<String> readBinaryWatch(int num) {
        final List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h << 6 | m) == num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }
}
