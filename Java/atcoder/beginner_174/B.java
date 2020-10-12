package atcoder.beginner_174;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line = in.nextLine().split(" ");
        final int n = Integer.parseInt(line[0]);
        final double d = Integer.parseInt(line[1]);
        int res = 0;
        for (int i = 0; i < n; i++) {
            final String[] curr = in.nextLine().split(" ");
            final long a = Long.parseLong(curr[0]);
            final long b = Long.parseLong(curr[1]);
            final double currD = Math.sqrt((a * a) + (b * b));
            if (Double.compare(currD, d) <= 0) {
                res++;
            }
        }
        System.out.println(res);
    }
}
