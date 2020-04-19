package kickstart.round_b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class P_4 {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final WanderingRobot solver = new WanderingRobot();
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            System.out.printf("Case #%d: %.10f\n", x, solver.solve(in));
        }
    }

    static class WanderingRobot {
        double[] logfact;

        public double solve(Scanner in) {
            final int w = in.nextInt();
            final int h = in.nextInt();
            int l = in.nextInt() - 1;
            int u = in.nextInt() - 1;
            final int r = in.nextInt() - 1;
            final int d = in.nextInt() - 1;
            if (d == h - 1) {
                l = 0;
            }
            if (r == w - 1) {
                u = 0;
            }
            if (l == 0 && u == 0) {
                return 0;
            }
            logfact = new double[w + h];
            for (int i = 1; i < logfact.length; i++) {
                logfact[i] = logfact[i - 1] + Math.log(i);
            }
            final double denom = (w - 1 + h - 1) * Math.log(2);
            double tot = Double.NEGATIVE_INFINITY;
            if (u > 0) {
                for (int i = l; i <= r; i++) {
                    final double c = get(u - 1, i) + Math.log(2) * (h - u - 1 + w - i - 1);
                    tot = addLog(tot, c);
                }
            }
            if (l > 0) {
                for (int i = u; i <= d; i++) {
                    final double c = get(l - 1, i) + Math.log(2) * (h - i - 1 + w - l - 1);
                    tot = addLog(tot, c);
                }
            }
            tot -= denom;
            return 1 - Math.exp(tot);
        }

        private double binom(int n, int k) {
            if (k > n) {
                return Double.NEGATIVE_INFINITY;
            }
            return logfact[n] - logfact[k] - logfact[n - k];
        }

        private static double addLog(double a1, double a2) {
            return a2 > a1 ? addLog(a2, a1) : a1 + Math.log(1 + Math.exp(a2 - a1));
        }

        private double get(int a, int b) {
            return binom(a + b, b);
        }
    }
}
