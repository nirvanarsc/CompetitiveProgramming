package atcoder.aising;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int l = in.nextInt();
        final int r = in.nextInt();
        final int d = in.nextInt();
        in.nextLine();
        int res = 0;
        for (int i = l; i <= r; i++) {
            if (i % d == 0) {
                res++;
            }
        }
        System.out.println(res);
    }
}
