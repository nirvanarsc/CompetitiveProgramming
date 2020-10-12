package atcoder.aising;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        int res = 0;
        for (int i = 1; i <= n; i++) {
            final int curr = in.nextInt();
            if (i % 2 != 0 && curr % 2 != 0) {
                res++;
            }
        }
        in.nextLine();
        System.out.println(res);
    }
}
