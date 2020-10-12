package atcoder.m_solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int k = in.nextInt();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = k; i < n; i++) {
            if (arr[i - k] >= arr[i]) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
