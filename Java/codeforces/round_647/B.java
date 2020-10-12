package codeforces.round_647;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        outer:
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(in.nextInt());
            }
            for (int i = 1; i < 1024; i++) {
                boolean pass = true;
                for (int num : set) {
                    if (!set.contains(num ^ i)) {
                        pass = false;
                        break;
                    }
                }
                if (pass) {
                    System.out.println(i);
                    continue outer;
                }
            }
            System.out.println(-1);
        }
    }
}
