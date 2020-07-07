package medium;

import java.util.Random;

@SuppressWarnings("unused")
public class P_478 {

    static class Solution {
        Random rand;
        double x;
        double y;
        double r;

        Solution(double radius, double x_center, double y_center) {
            rand = new Random();
            r = radius;
            x = x_center;
            y = y_center;
        }

        public double[] randPoint() {
            while (true) {
                final double randomX = 2 * r * Math.random();
                final double randomY = 2 * r * Math.random();
                final double dist = Math.hypot(randomX - r, randomY - r);
                if (dist <= r) {
                    return new double[] { randomX, randomY };
                }
            }
        }

        public double[] randPointTrig() {
            final double len = Math.sqrt(Math.random()) * r;
            final double deg = Math.random() * 2 * Math.PI;
            final double randomX = x + len * Math.cos(deg);
            final double randomY = y + len * Math.sin(deg);
            return new double[] { randomX, randomY };
        }
    }
}
