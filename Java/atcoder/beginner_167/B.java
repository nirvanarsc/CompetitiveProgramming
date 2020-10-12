package atcoder.beginner_167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int a = in.nextInt();
        final int b = in.nextInt();
        final int c = in.nextInt();
        final int k = in.nextInt();
        in.nextLine();
        if (a > k) {
            System.out.println(k);
        } else if (a + b >= k) {
            System.out.println(a);
        } else {
            final int diff = k - (a + b);
            System.out.println(a - diff);
        }
    }
}
