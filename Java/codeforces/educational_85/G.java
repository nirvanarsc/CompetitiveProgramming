package codeforces.educational_85;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class G {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[i] = in.nextInt();
        }
        in.nextLine();
        final String t = in.nextLine();
        final String s = in.nextLine();
        for (int i = 0; i + t.length() <= s.length(); i++) {
            boolean match = true;
            for (int j = i, k = 0; j < i + t.length(); j++, k++) {
                if (t.charAt(k) != s.charAt(j) && map[t.charAt(k) - 'a'] != s.charAt(j) - 'a' + 1) {
                    match = false;
                    break;
                }
            }
            System.out.print(match ? '1' : '0');

        }
        System.out.println();
    }
}
