package leetcode.medium;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic" })
public class P_478 {

    class Solution {
        double x;
        double y;
        double r;

        Solution(double radius, double x_center, double y_center) {
            r = radius;
            x = x_center;
            y = y_center;
        }

        public double[] randPoint() {
            while (true) {
                final double randomX = 2 * r * Math.random() - r;
                final double randomY = 2 * r * Math.random() - r;
                final double dist = Math.hypot(randomX, randomY);
                if (dist <= r) {
                    return new double[] { x + randomX, y + randomY };
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
