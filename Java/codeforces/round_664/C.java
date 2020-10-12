package codeforces.round_664;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line = in.nextLine().split(" ");
        final int n = Integer.parseInt(line[0]);
        final int m = Integer.parseInt(line[1]);
        final int[] a = new int[n];
        final int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        in.nextLine();
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        in.nextLine();
        for (int res = 0; res < 1 << 9; res++) {
            boolean ok = true;
            for (int aVal : a) {
                boolean currOk = false;
                for (int bVal : b) {
                    if ((aVal & bVal & ~res) == 0) {
                        currOk = true;
                        break;
                    }
                }
                if (!currOk) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                System.out.println(res);
                return;
            }
        }
    }
}
