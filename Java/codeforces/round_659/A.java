package codeforces.round_659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            in.nextLine();
            StringBuilder prev = new StringBuilder();
            prev.append("a".repeat(50));
            System.out.println(prev);
            for (int num : arr) {
                final StringBuilder next = new StringBuilder(prev.substring(0, num));
                for (int i = num; i < 50; i++) {
                    int nC = prev.charAt(i) + 1;
                    if (nC == 123) {
                        nC = 97;
                    }
                    next.append((char) nC);
                }
                System.out.println(next);
                prev = next;
            }
        }
    }
}
