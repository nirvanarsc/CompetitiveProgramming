package atcoder.tokio_marine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final long first = in.nextLong();
        final long v = in.nextLong();
        in.nextLine();
        final long second = in.nextLong();
        final long w = in.nextLong();
        in.nextLine();
        final long t = in.nextLong();
        if (v <= w) {
            System.out.println("NO");
        } else {
            final long diff = Math.abs(v - w);
            if (t * diff >= Math.abs(second - first)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
