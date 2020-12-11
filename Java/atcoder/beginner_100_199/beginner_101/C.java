package atcoder.beginner_100_199.beginner_101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line = in.nextLine().split(" ");
        final int n = Integer.parseInt(line[0]);
        final int k = Integer.parseInt(line[1]);
        for (int i = 0; i < n; i++) {
            in.nextInt();
        }
        in.nextLine();
        System.out.println((int) Math.ceil((double) (n - 1) / (k - 1)));
    }
}
