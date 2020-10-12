package atcoder.beginner_174;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final String word = in.nextLine();
        int red = 0;
        for (char c : word.toCharArray()) {
            if (c == 'R') {
                red++;
            }
        }
        System.out.println(Math.min(red, getSwaps(n, word, red)));
    }

    private static int getSwaps(int n, String word, int color) {
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == 'W') {
                swaps++;
            }
            if (--color == 0) {
                break;
            }
        }
        return swaps;
    }
}
