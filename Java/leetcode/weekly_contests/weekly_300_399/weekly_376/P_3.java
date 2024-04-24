package leetcode.weekly_contests.weekly_300_399.weekly_376;

import java.util.Arrays;

public class P_3 {

    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        long res = (long) 9e18;
        for (int v : ff(nums[n / 2])) {
            res = Math.min(res, f(nums, v));
        }
        if (n % 2 == 0) {
            for (int v : ff(nums[(n / 2) - 1])) {
                res = Math.min(res, f(nums, v));
            }
        }
        return res;
    }

    private static int[] ff(int num) {
        final char[] w = String.valueOf(num).toCharArray();
        final int n = w.length;
        for (int i = 0; i < n / 2; i++) {
            w[n - i - 1] = w[i];
        }
        return new int[] { Integer.parseInt(new String(w)), add(n, w.clone()), remove(n, w.clone()) };
    }

    private static int add(int n, char[] w) {
        final char[] nine = new char[n];
        Arrays.fill(nine, '9');
        if (Arrays.equals(nine, w)) {
            final int res = Integer.parseInt(new String(w)) + 2;
            return res == (int) (1e9 + 1) ? (int) 2e9 : res;
        }
        int i = (n / 2) - (n + 1) % 2;
        int j = n / 2;
        int carry;
        do {
            carry = 0;
            w[i]++;
            if (i != j) {
                w[j]++;
            }
            if (w[i] == ':') {
                carry = 1;
                w[i] = '0';
                w[j] = '0';
            }
            i--;
            j++;
        } while (carry > 0);
        return Integer.parseInt(new String(w));
    }

    private static int remove(int n, char[] w) {
        final char[] one = new char[n];
        Arrays.fill(one, '0');
        one[0] = one[n - 1] = '1';
        if (Arrays.equals(one, w)) {
            final int res = Integer.parseInt(new String(w)) - 2;
            return res == -1 ? (int) 2e9 : res;
        }
        int i = (n / 2) - (n + 1) % 2;
        int j = n / 2;
        int carry = 0;
        do {
            carry = 0;
            w[i]--;
            if (i != j) {
                w[j]--;
            }
            if (w[i] == '/') {
                carry = 1;
                w[i] = '9';
                w[j] = '9';
            }
            i--;
            j++;
        } while (carry > 0);
        return Integer.parseInt(new String(w));
    }

    private static long f(int[] nums, int median) {
        if (median == -1) {
            return (long) 9e18;
        }
        long res = 0;
        for (int num : nums) {
            res += Math.abs(median - num);
        }
        return res;
    }
}
