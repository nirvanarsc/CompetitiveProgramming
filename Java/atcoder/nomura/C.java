package atcoder.nomura;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt() + 1;
        in.nextLine();
        final int[] leaves = new int[n];
        long branch = 0;
        for (int i = 0; i < n; i++) {
            leaves[i] = in.nextInt();
            branch += leaves[i];
        }
        branch--;
        long res = 0;
        long curr = 1;
        for (int i = 0; i < n; i++) {
            res += curr;
            curr -= leaves[i];
            if (curr < 0) {
                res = -1;
                break;
            }
            if (curr <= branch) {
                branch -= curr;
                curr *= 2;
            } else {
                curr += branch;
                branch = 0;
            }
        }
        System.out.println(res);
    }
}
