package codeforces.round_650_699.round_658;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final String s1 = in.nextLine();
            final String s2 = in.nextLine();
            final List<Integer> first = new ArrayList<>();
            final List<Integer> second = new ArrayList<>();
            flipZero(s1, n, first);
            flipZero(s2, n, second);
            Collections.reverse(second);
            first.addAll(second);
            System.out.print(first.size() + " ");
            for (int num : first) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void flipZero(String str, int n, List<Integer> first) {
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                first.add(i + 1);
            }
        }
        if (str.charAt(str.length() - 1) == '1') {
            first.add(n);
        }
    }
}
