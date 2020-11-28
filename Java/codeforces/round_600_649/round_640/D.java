package codeforces.round_600_649.round_640;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int[] arr = new int[n];
            final Deque<Integer> list = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                list.offerLast(arr[i]);
            }
            boolean turn = true;
            int a = 0, b = 0, prev = 0, count;
            for (count = 0; !list.isEmpty(); count++) {
                int sum = 0;
                if (turn) {
                    while (sum <= prev && !list.isEmpty()) {
                        sum += list.removeFirst();
                    }
                    a += sum;
                } else {
                    while (sum <= prev && !list.isEmpty()) {
                        sum += list.removeLast();
                    }
                    b += sum;
                }
                prev = sum;
                turn ^= true;
            }
            System.out.println(count + " " + a + ' ' + b);
        }
    }
}
