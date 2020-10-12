package codeforces.round_650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String str = in.nextLine();
            final StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            for (int i = 1; i < str.length(); i += 2) {
                sb.append(str.charAt(i));
            }
            System.out.println(sb);
        }
    }
}
