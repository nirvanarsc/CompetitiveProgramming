package medium;

public class P_360 {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        final int n = nums.length;
        int start = 0, end = n - 1;
        final int[] res = new int[n];
        if (a > 0) {
            for (int i = n - 1; i >= 0; i--) {
                final int x = f(nums[start], a, b, c);
                final int y = f(nums[end], a, b, c);
                if (x > y) {
                    res[i] = x;
                    start++;
                } else {
                    res[i] = y;
                    end--;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                final int x = f(nums[start], a, b, c);
                final int y = f(nums[end], a, b, c);
                if (x < y) {
                    res[i] = x;
                    start++;
                } else {
                    res[i] = y;
                    end--;
                }
            }
        }
        return res;
    }

    private static int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
