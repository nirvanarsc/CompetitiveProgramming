package codeforces.round_650_699.round_661;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final String s = in.nextLine();
            final PriorityQueue<List<Integer>> zero = new PriorityQueue<>(
                    (a, b) -> Integer.compare(b.size(), a.size()));
            final PriorityQueue<List<Integer>> one = new PriorityQueue<>(
                    (a, b) -> Integer.compare(b.size(), a.size()));
            for (int i = 0; i < n; i++) {
                final char c = s.charAt(i);
                if (c == '0') {
                    if (one.isEmpty()) {
                        zero.add(new ArrayList<>(Collections.singleton(i)));
                    } else {
                        final List<Integer> curr = one.remove();
                        curr.add(i);
                        zero.add(curr);
                    }
                } else {
                    if (zero.isEmpty()) {
                        one.add(new ArrayList<>(Collections.singleton(i)));
                    } else {
                        final List<Integer> curr = zero.remove();
                        curr.add(i);
                        one.add(curr);
                    }
                }
            }
            int idx = 1;
            final int[] res = new int[n];
            while (!zero.isEmpty()) {
                for (int num : zero.remove()) {
                    res[num] = idx;
                }
                idx++;
            }
            while (!one.isEmpty()) {
                for (int num : one.remove()) {
                    res[num] = idx;
                }
                idx++;
            }
            System.out.println(idx - 1);
            for (int num : res) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
