package leetcode.weekly_contests.weekly_200_299.weekly_274;

import java.util.Arrays;

public class P_3 {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long curr = mass;
        for (int a : asteroids) {
            if (a > curr) {
                return false;
            }
            curr += a;
        }
        return true;
    }
}
