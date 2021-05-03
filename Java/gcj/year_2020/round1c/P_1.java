package gcj.year_2020.round1c;

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
            int x = in.nextInt();
            int y = in.nextInt();
            final String moves = in.next();
            for (int i = 0; i < moves.length(); i++) {
                x += moves.charAt(i) == 'E' ? +1 : 0;
                x += moves.charAt(i) == 'W' ? -1 : 0;
                y += moves.charAt(i) == 'N' ? +1 : 0;
                y += moves.charAt(i) == 'S' ? -1 : 0;
                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    return String.valueOf(i + 1);
                }
            }
            return "IMPOSSIBLE";
        }
    }
}
