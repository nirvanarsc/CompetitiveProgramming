package atcoder.beginner_100_199.beginner_170;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        in.nextLine();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        final int max = arr[n - 1];
        final boolean[] sieve = new boolean[max + 1];
        Arrays.fill(sieve, true);
        for (int num : arr) {
            for (int p = 2 * num; p <= max; p += num) {
                sieve[p] = false;
            }
        }
        final Set<Integer> res = new HashSet<>();
        final Set<Integer> remove = new HashSet<>();
        for (int num : arr) {
            if (sieve[num]) {
                if (!res.add(num)) {
                    remove.add(num);
                }
            }
        }
        System.out.println(res.size() - remove.size());
    }
}
