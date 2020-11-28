package codeforces.round_650_699.round_651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[2 * n];
            final Deque<Integer> odds = new ArrayDeque<>();
            final Deque<Integer> evens = new ArrayDeque<>();
            for (int i = 0; i < 2 * n; i++) {
                arr[i] = in.nextInt();
                if (arr[i] % 2 == 0) {
                    evens.addFirst(i + 1);
                } else {
                    odds.addFirst(i + 1);
                }
            }
            in.nextLine();
            if (odds.size() % 2 != 0 && evens.size() % 2 != 0) {
                odds.removeFirst();
                evens.removeFirst();
            } else {
                if(odds.size() > evens.size()) {
                    odds.removeFirst();
                    odds.removeFirst();
                } else {
                    evens.removeFirst();
                    evens.removeFirst();
                }
            }
            while (!odds.isEmpty()) {
                System.out.println(odds.removeFirst() + " " + odds.removeFirst());
            }
            while (!evens.isEmpty()) {
                System.out.println(evens.removeFirst() + " " + evens.removeFirst());
            }
        }
    }
}
