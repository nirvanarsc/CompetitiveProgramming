package codeforces.round_643;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int a = in.nextInt();
        final int b = in.nextInt();
        final int c = in.nextInt();
        final int d = in.nextInt();
        final int N = 20;
        final int[] S = new int[N];
        long res = 0;
        S[a + b]++;
        S[a + c + 1]--;
        S[b + b + 1]--;
        S[b + c + 2]++;
        System.out.println(Arrays.toString(S));
        for (int i = 1; i < N; i++) {
            S[i] += S[i - 1];
        }
        for (int i = 1; i < N; i++) {
            S[i] += S[i - 1];
        }
        System.out.println(Arrays.toString(S));
        for (int i = c + 1; i < N; i++) {
            res += (long) S[i] * (Math.min(i, d + 1) - c);
        }
        System.out.println(res);
    }
}
