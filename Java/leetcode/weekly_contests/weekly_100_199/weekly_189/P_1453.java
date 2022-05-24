package leetcode.weekly_contests.weekly_100_199.weekly_189;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1453 {

    static class Pair {
        double d;
        boolean b;

        Pair(double d, boolean b) {
            this.d = d;
            this.b = b;
        }
    }

    static class Complex {
        private final double re;
        private final double im;

        Complex(double real, double imag) {
            re = real;
            im = imag;
        }

        public double abs() {
            return Math.hypot(re, im);
        }

        public double phase() {
            return Math.atan2(im, re);
        }

        public Complex minus(Complex b) {
            final Complex a = this;
            final double real = a.re - b.re;
            final double imag = a.im - b.im;
            return new Complex(real, imag);
        }
    }

    private static final int MAX_POINTS = 105;

    private static int getPointsInside(Complex[] complexes, double[][] distance, int i, double r) {
        final List<Pair> angles = new ArrayList<>();
        for (int j = 0; j < complexes.length; j++) {
            if (i != j && distance[i][j] <= 2 * r) {
                final double B = StrictMath.acos(distance[i][j] / (2 * r));
                final double A = complexes[i].minus(complexes[j]).phase();
                final double alpha = A - B;
                final double beta = A + B;
                angles.add(new Pair(alpha, true));
                angles.add(new Pair(beta, false));
            }
        }
        angles.sort((a, b) -> Double.compare(a.d, b.d) == 0 ? Boolean.compare(b.b, a.b)
                                                            : Double.compare(a.d, b.d));
        int count = 1, res = 1;
        for (Pair p : angles) {
            if (p.b) {
                count++;
            } else {
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public int numPointsAS(int[][] points, int r) {
        final double[][] distance = new double[MAX_POINTS][MAX_POINTS];
        final Complex[] complexes = Arrays.stream(points)
                                          .map(x -> new Complex(x[0], x[1]))
                                          .toArray(Complex[]::new);
        for (int i = 0; i < complexes.length; i++) {
            for (int j = i + 1; j < complexes.length; j++) {
                distance[i][j] = distance[j][i] = complexes[i].minus(complexes[j]).abs();
            }
        }
        int ans = 0;
        for (int i = 0; i < complexes.length; i++) {
            ans = Math.max(ans, getPointsInside(complexes, distance, i, r));
        }
        return ans;
    }

    private static boolean isInside(double circle_x, double circle_y, double rad, int x, int y) {
        return (x - circle_x) * (x - circle_x) + (y - circle_y) * (y - circle_y) <= rad * rad;
    }

    public int numPoints(int[][] points, int r) {
        int res = 1;
        for (int i = 0; i < points.length; i++) {
            final int x1 = points[i][0];
            final int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                final int x2 = points[j][0];
                final int y2 = points[j][1];

                final double x3 = (x1 + x2) / 2.0;
                final double y3 = (y1 + y2) / 2.0;

                final double qHypot = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
                final double rHypot = Math.sqrt(r * r - qHypot * 0.25);

                final double basex = rHypot * (y1 - y2) / Math.sqrt(qHypot);
                final double basey = rHypot * (x2 - x1) / Math.sqrt(qHypot);

                final double centerx1 = x3 + basex;
                final double centery1 = y3 + basey;
                final double centerx2 = x3 - basex;
                final double centery2 = y3 - basey;

                int first = 0;
                int second = 0;
                for (int[] p : points) {
                    if (isInside(centerx1, centery1, r, p[0], p[1])) {
                        first++;
                    }
                    if (isInside(centerx2, centery2, r, p[0], p[1])) {
                        second++;
                    }
                }
                res = Math.max(res, Math.max(first, second));
            }
        }
        return res;
    }
}
