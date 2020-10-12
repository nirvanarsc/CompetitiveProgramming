package atcoder.beginner_171;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class E {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final int[] arr = new int[n];
        int totalXor = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            totalXor ^= arr[i];
        }
        in.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print((totalXor ^ arr[i]) + " ");
        }
        System.out.println();
    }
}
