package codeforces.round_600_649.round_639;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int[] rooms = new int[n];
            for (int i = 0; i < n; i++) {
                rooms[i] = in.nextInt();
            }
            in.nextLine();
            boolean flag = false;
            final Set<Long> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                final long curr = Math.floorMod(i + rooms[i], n);
                if (!set.add(curr)) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag ? "NO" : "YES");
        }
    }
}
