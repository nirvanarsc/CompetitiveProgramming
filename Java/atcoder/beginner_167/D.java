package atcoder.beginner_167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        long k = in.nextLong();
        in.nextLine();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        if (k <= n) {
            int res;
            for (res = 1; k > 0; k--) {
                res = arr[res - 1];
            }
            System.out.println(res);
            return;
        }
        int slow = 1;
        int fast = 1;
        int cycle = 0;
        int initial = 0;
        do {
            slow = arr[slow - 1];
            fast = arr[arr[fast - 1] - 1];
        } while (slow != fast);
        do {
            slow = arr[slow - 1];
            cycle++;
        } while (slow != fast);
        slow = 1;
        while (slow != fast) {
            slow = arr[slow - 1];
            fast = arr[fast - 1];
            initial++;
        }
        k -= initial;
        k = Math.floorMod(k, cycle);
        int res;
        for (res = slow; k > 0; k--) {
            res = arr[res - 1];
        }
        System.out.println(res);
    }
}
