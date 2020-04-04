package gcj.qualifying;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class NestingDepth {

    @SuppressWarnings("StringRepeatCanBeUsed")
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 1; x <= t; x++) {
            final String line = in.nextLine();
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                final char prev = i == 0 ? '0' : line.charAt(i - 1);
                final char curr = line.charAt(i);
                if (prev > curr) {
                    for (int k = 0; k < prev - curr; k++) {
                        sb.append(')');
                    }
                } else {
                    for (int k = 0; k < curr - prev; k++) {
                        sb.append('(');
                    }
                }
                sb.append(curr);
                if (i == line.length() - 1) {
                    for (char k = '0'; k < line.charAt(i); k++) {
                        sb.append(')');
                    }
                }
            }
            System.out.println("Case #" + x + ": " + sb);
        }
    }
}
