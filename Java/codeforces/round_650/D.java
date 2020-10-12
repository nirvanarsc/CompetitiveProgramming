package codeforces.round_650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String s = in.nextLine();
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = Arrays.stream(in.nextLine().split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
            final int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            final char[] res = new char[n];
            final boolean[] seen = new boolean[n];
            for (char c = 'z'; c >= 'a'; c--) {
                final List<Integer> indexes = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (arr[j] == 0 && !seen[j]) {
                        indexes.add(j);
                    }
                }
                if (indexes.size() <= freq[c - 'a']) {
                    for (int idx : indexes) {
                        seen[idx] = true;
                        res[idx] = c;
                    }
                    for (int idx : indexes) {
                        for (int i = 0; i < n; i++) {
                            if (!seen[i]) {
                                arr[i] -= Math.abs(idx - i);
                            }
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}
