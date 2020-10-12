package codeforces.round_659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    static class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        outer:
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            final int l = in.nextInt();
            final int[] arr = new int[n];
            in.nextLine();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            in.nextLine();
            final Pair temp = new Pair(-k, k);
            for (int i = 0; i < n; i++) {
                final int maxDepth = Math.min(k, l - arr[i]);
                final Pair curr = new Pair(-maxDepth, maxDepth);
                if (maxDepth == k) {
                    temp.left = -k;
                    temp.right = k;
                    continue;
                }
                temp.left = Math.max(temp.left + 1, curr.left);
                temp.right = curr.right;
                if (temp.left > temp.right) {
                    System.out.println("NO");
                    continue outer;
                }
            }
            System.out.println("YES");
        }
    }
}
