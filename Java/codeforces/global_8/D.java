package codeforces.global_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final long[] arr = Arrays.stream(in.nextLine().split(" "))
                                 .mapToLong(Long::parseLong)
                                 .toArray();
        final int[] count = new int[Long.SIZE];
        int totalBits = 0;
        for (long tt : arr) {
            for (int i = 0; i < Long.SIZE; i++) {
                if ((tt & (1L << i)) != 0) {
                    count[i]++;
                    totalBits++;
                }
            }
        }
        long res = 0;
        while (totalBits > 0) {
            long curr = 0;
            for (int i = 0; i < Long.SIZE; i++) {
                if (count[i] > 0) {
                    curr |= 1L << i;
                    count[i]--;
                    totalBits--;
                }
            }
            res += curr * curr;
        }
        System.out.println(res);
    }
}
