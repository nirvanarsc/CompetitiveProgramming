package atcoder.beginner_175;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line = in.nextLine().split(" ");
        long x = Long.parseLong(line[0]);
        long k = Long.parseLong(line[1]);
        long d = Long.parseLong(line[2]);
        x = Math.abs(x);
        if ((x / d) >= k) {
            System.out.println(x - d * k);
        } else {
            k -= x / d;
            long r = x % d;
            if (k % 2 == 0) {
                System.out.println(r);
            } else {
                System.out.println(d - r);
            }
        }
    }
}
