package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class P_149 {

    public int maxPoints(int[][] points) {
        int solution = 0;
        for (int i = 0; i < points.length; i++) {
            final Map<String, Integer> map = new HashMap<>();
            int duplicate = 0;
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
                final int deltaX = points[j][0] - points[i][0];
                final int deltaY = points[j][1] - points[i][1];
                if (deltaX == 0 && deltaY == 0) {
                    duplicate++;
                    continue;
                }
                final int gcd = gcd(deltaX, deltaY);
                final int dX = deltaX / gcd;
                final int dY = deltaY / gcd;
                max = Math.max(max, map.merge(dX + "," + dY, 1, Integer::sum));
            }
            solution = Math.max(solution, max + duplicate + 1);
        }
        return solution;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
