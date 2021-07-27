package codeforces.global.global_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final long k = Long.parseLong(in.nextLine());
        final StringBuilder sb = new StringBuilder();
        final int[] count = new int[10];
        Arrays.fill(count, 1);
        long prod = 1;
        int i = 0;
        while (prod < k) {
            count[i++ % 10]++;
            prod = 1;
            for (int num : count) {
                prod *= num;
            }
        }
        final String codef = "codeforces";
        for (int j = 0; j < 10; j++) {
            for (int t = 0; t < count[j]; t++) {
                sb.append(codef.charAt(j));
            }
        }
        System.out.println(sb);
    }
}
