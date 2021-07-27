package codeforces.global.global_9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String[] str = in.nextLine().split(" ");
            final int n = Integer.parseInt(str[0]);
            final int m = Integer.parseInt(str[1]);
            boolean canDo = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    final int curr = in.nextInt();
                    final int resCell = getResCell(n, m, i, j);
                    if (curr > resCell) {
                        canDo = false;
                    }
                }
                in.nextLine();
            }
            if (canDo) {
                System.out.println("YES");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(getResCell(n, m, i, j) + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("NO");
            }
        }
    }

    private static int getResCell(int n, int m, int i, int j) {
        int resCell = 2;
        if (i > 0 && i < n - 1) {
            resCell++;
        }
        if (j > 0 && j < m - 1) {
            resCell++;
        }
        return resCell;
    }
}
