package codeforces.round_650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int dist = in.nextInt();
            in.nextLine();
            final char[] line = ('1' + "0".repeat(dist) + in.nextLine() + "0".repeat(dist) + '1').toCharArray();
            int res = 0;
            int curr = 0;
            for (char c : line) {
                if (c == '0') {
                    curr++;
                } else {
                    res += Math.max(0, (curr - dist) / (dist + 1));
                    curr = 0;
                }
            }
            System.out.println(res);
        }
    }
}
