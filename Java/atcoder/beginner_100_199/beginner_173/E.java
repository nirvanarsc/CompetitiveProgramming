package atcoder.beginner_100_199.beginner_173;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class E {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int k = in.nextInt();
        in.nextLine();
        final long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        in.nextLine();
        System.out.println(solve(arr, k));
    }

    private static int solve(long[] nums, int k) {
        final int n = nums.length;
        Arrays.sort(nums);
        long product = 1;
        if (nums[n - 1] <= 0 && k % 2 != 0) {
            for (int i = n - 1; i >= n - k; i--) {
                product = (product * nums[i]) % MOD;
            }
            return Math.floorMod(product, MOD);
        }
        int i = 0;
        int j = n - 1;
        if (k % 2 != 0) {
            product = (product * nums[j]) % MOD;
            j--;
            k--;
        }
        k >>= 1;
        for (int itr = 0; itr < k; itr++) {
            final long left = nums[i] * nums[i + 1];
            final long right = nums[j] * nums[j - 1];
            if (left > right) {
                product = (product * (left % MOD)) % MOD;
                i += 2;
            } else {
                product = (product * (right % MOD)) % MOD;
                j -= 2;
            }
        }
        return Math.floorMod(product, MOD);
    }
}
