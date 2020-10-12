package codeforces.round_657;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        outer:
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            final int init = test(s);
            if (init == 1) {
                s = s.replace('?', 'z');
                System.out.println("Yes");
                System.out.println(s);
            } else if (init >= 2) {
                System.out.println("No");
            } else if (init == 0) {
                final String target = "abacaba";
                for (int i = 0; i < s.length(); i++) {
                    int idx = 0;
                    final char[] res = s.toCharArray();
                    for (int j = i; j < s.length() && idx < target.length(); j++) {
                        if (res[j] == target.charAt(idx)) {
                            idx++;
                        } else if (res[j] == '?') {
                            res[j] = target.charAt(idx);
                            idx++;
                        } else {
                            break;
                        }
                    }
                    if (idx == target.length()) {
                        String temp = new String(res);
                        temp = temp.replace('?', 'z');
                        if (test(temp) == 1) {
                            System.out.println("Yes");
                            System.out.println(temp);
                            continue outer;
                        }
                    }
                }
                System.out.println("No");
            }
        }
    }

    private static int test(String s) {
        int idx = 0;
        int count = -1;
        while (idx != -1) {
            final int n = s.indexOf("abacaba", idx);
            count++;
            if (n != -1) {
                idx = n + 1;
            } else {
                idx = -1;
            }
        }
        return count;
    }
}
