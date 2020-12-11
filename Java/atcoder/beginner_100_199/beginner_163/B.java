package atcoder.beginner_100_199.beginner_163;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int s = in.nextInt();
        final int n = in.nextInt();
        in.nextLine();
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += in.nextInt();
        }
        System.out.println(total > s ? -1 : s - total);
    }
}
