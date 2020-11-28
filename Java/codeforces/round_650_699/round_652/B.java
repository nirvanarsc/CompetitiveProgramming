package codeforces.round_650_699.round_652;

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
            final String s = in.nextLine();
            final Deque<Character> stack = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; i--) {
                final char c = s.charAt(i);
                if (c == '1') {
                    if (!stack.isEmpty() && stack.getFirst() == '0') {
                        while (!stack.isEmpty() && stack.getFirst() == '0') {
                            stack.removeFirst();
                        }
                        stack.addFirst('0');
                        continue;
                    }
                    stack.addFirst('1');
                } else {
                    stack.addFirst(c);
                }
            }
            final StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.removeFirst());
            }
            System.out.println(sb);
        }
    }
}
