package gcj.year_2020.round1b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class P_3 {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final CurrProblem solver = new CurrProblem();
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            System.out.printf("Case #%d: %d\n", x, solver.solve(in));
        }
    }

    static class CurrProblem {
        public int solve(Scanner in) {
            final int w = in.nextInt();
            final int h = in.nextInt();
            return w + h;
        }
    }
}
