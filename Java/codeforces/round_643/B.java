package codeforces.round_643;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        final String key = "123";
        for (int x = 0; x < t; x++) {
            final String k = in.nextLine();
            System.out.println(minWindow(k, key));
        }
    }

    public static int minWindow(String s, String t) {
        final int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int min = Integer.MAX_VALUE;
        int matches = t.length();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]-- > 0) {
                matches--;
            }
            while (matches == 0) {
                if (min > i - j + 1) {
                    min = i - j + 1;
                }
                if (++count[s.charAt(j++)] > 0) {
                    matches++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
