package codeforces.educational.educational_90;

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
            final String s = in.nextLine();
            final Deque<Character> stack = new ArrayDeque<>();
            int pairs = 0;
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peekFirst() != c) {
                    pairs++;
                    stack.removeFirst();
                } else {
                    stack.addFirst(c);
                }
            }
            System.out.println(pairs % 2 != 0 ? "DA" : "NET");
        }
    }
}
