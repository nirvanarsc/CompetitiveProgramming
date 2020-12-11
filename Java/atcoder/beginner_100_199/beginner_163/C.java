package atcoder.beginner_100_199.beginner_163;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        in.nextLine();
        final int[] members = new int[n];
        for (int i = 1; i < n; i++) {
            members[in.nextInt() - 1]++;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(members[i]);
        }
    }
}
