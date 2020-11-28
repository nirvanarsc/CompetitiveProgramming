package codeforces.round_650_699.round_660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final StringBuilder ans = new StringBuilder();
            final int numEight = (n - 1) / 4 + 1;
            ans.append("9".repeat(Math.max(0, n - numEight)));
            ans.append("8".repeat(Math.max(0, numEight)));
            System.out.println(ans);
        }
    }
}
