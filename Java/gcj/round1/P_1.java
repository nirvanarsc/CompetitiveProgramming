package gcj.round1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class P_1 {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            final int n = in.nextInt();
            in.nextLine();
            String beginning = "";
            String ending = "";
            boolean possible = true;
            final StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                final String s = in.nextLine();
                final String[] strings = s.split("\\*", -1);
                final String b = strings[0];
                final String e = strings[strings.length - 1];
                if (b.length() > beginning.length()) {
                    if (!b.startsWith(beginning)) {
                        possible = false;
                    }
                    beginning = b;
                } else {
                    if (!beginning.startsWith(b)) {
                        possible = false;
                    }
                }
                if (e.length() > ending.length()) {
                    if (!e.endsWith(ending)) {
                        possible = false;
                    }
                    ending = e;
                } else {
                    if (!ending.endsWith(e)) {
                        possible = false;
                    }
                }
                if (strings.length > 2) {
                    for (int j = 1; j < strings.length - 1; j++) {
                        builder.append(strings[j]);
                    }
                }
            }
            final String res = possible ? (beginning + builder + ending) : "*";
            System.out.println("Case #" + x + ": " + res);
        }
    }
}
