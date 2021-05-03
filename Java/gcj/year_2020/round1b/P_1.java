package gcj.year_2020.round1b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class P_1 {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final CurrProblem solver = new CurrProblem();
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            System.out.printf("Case #%d: %s\n", x, solver.solve(in));
        }
    }

    static class CurrProblem {
        public String solve(Scanner in) {
            final int x = in.nextInt();
            final int y = in.nextInt();
            for (int i = 0; i <= 30; i++) {
                final String solved = calc(x, y, i);
                if (solved != null) {
                    return solved;
                }
            }
            return "IMPOSSIBLE";
        }

        @SuppressWarnings({ "ConstantConditions", "ReturnOfNull" })
        private static String calc(long x, long y, int i) {
            final StringBuilder ans = new StringBuilder();
            for (int step = i; step >= 0; step--) {
                final long move = 1L << step;
                if (Math.abs(x) > Math.abs(y)) {
                    if (x > 0) {
                        x -= move;
                        ans.append('E');
                    } else {
                        x += move;
                        ans.append('W');
                    }
                } else {
                    if (y > 0) {
                        y -= move;
                        ans.append('N');
                    } else {
                        y += move;
                        ans.append('S');
                    }
                }
            }
            if (x == 0L && y == 0L) {
                return ans.reverse().toString();
            }
            return null;
        }
    }
}
