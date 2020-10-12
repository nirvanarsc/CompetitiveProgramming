package codeforces.round_656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                arr[i] = in.nextInt();
            }
            in.nextLine();
            final LinkedHashSet<Integer> set = new LinkedHashSet<>();
            for (int num : arr) {
                set.add(num);
            }
            for (int num : set) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
