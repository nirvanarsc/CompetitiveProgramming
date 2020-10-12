package codeforces.round_642;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            int k = in.nextInt();
            in.nextLine();
            final PriorityQueue<Integer> pqA = new PriorityQueue<>();
            final PriorityQueue<Integer> pqB = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < n; i++) {
                pqA.add(in.nextInt());

            }
            in.nextLine();
            for (int i = 0; i < n; i++) {
                pqB.add(in.nextInt());

            }
            in.nextLine();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                final Integer a = pqA.remove();
                final Integer b = pqB.remove();
                if (a >= b) {
                    sum += a;
                } else if (k > 0) {
                    sum += b;
                    k--;
                } else {
                    sum += a;
                }
            }
            System.out.println(sum);
        }
    }
}
