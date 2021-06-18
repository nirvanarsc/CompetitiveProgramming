import java.util.Arrays;

public final class SplitArrayLargestSum {

    private static int minimizeMaximum(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for (int i : nums) {
            max = Math.max(max, i);
            sum += i;
        }

        int low = max;
        int high = sum;
        while (low < high) {
            final int mid = low + (high - low) / 2;
            final int pieces = cut(nums, mid);
            if (pieces > m) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int maximizeMinimum(int[] chocolate, int m) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : chocolate) {
            min = Math.min(min, i);
            sum += i;
        }
        int low = min;
        int high = sum;
        while (low < high) {
            final int mid = (low + high + 1) >>> 1;
            if (split(chocolate, mid) < m) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return low;
    }

    private static int cut(int[] arr, int mid) {
        int pieces = 1;
        int largest = 0;
        for (int i : arr) {
            largest += i;
            if (largest > mid) {
                largest = i;
                pieces++;
            }
        }
        return pieces;
    }

    private static int split(int[] chocolate, int minSweetness) {
        int peopleCount = 0;
        int sweetness = 0;
        for (int val : chocolate) {
            sweetness += val;
            if (sweetness >= minSweetness) {
                peopleCount++;
                sweetness = 0;
            }
        }
        return peopleCount;
    }

    private static int maxMinR(int[] chocolate, int m) {
        return findMaxMinOrMinMaxPartitionR(chocolate, m, true);
    }

    private static int maxMin(int[] chocolate, int m) {
        return findMaxMinOrMinMaxPartition(chocolate, m, true);
    }

    private static int minMaxR(int[] chocolate, int m) {
        return findMaxMinOrMinMaxPartitionR(chocolate, m, false);
    }

    private static int minMax(int[] chocolate, int m) {
        return findMaxMinOrMinMaxPartition(chocolate, m, false);
    }

    // Top down DP
    private static int findMaxMinOrMinMaxPartitionR(int[] nums, int m, boolean maxMin) {
        final int[][] dp = new int[nums.length][m + 1];
        final int[] sum = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            sum[i] = (i == nums.length - 1 ? 0 : sum[i + 1]) + nums[i];
        }
        return recurse(nums, 0, m, sum, dp, maxMin);
    }

    private static int recurse(int[] nums, int start, int m, int[] sums, int[][] dp, boolean maxMin) {
        if (m == 1) {
            return sums[start];
        }
        if (dp[start][m] > 0) {
            return dp[start][m];
        }
        int min = maxMin ? 0 : Integer.MAX_VALUE, sum = 0;
        for (int i = start; i <= nums.length - m; i++) {
            sum += nums[i];
            min = maxMin ? Math.max(Math.min(sum, recurse(nums, i + 1, m - 1, sums, dp, true)), min)
                         : Math.min(Math.max(sum, recurse(nums, i + 1, m - 1, sums, dp, false)), min);
        }
        dp[start][m] = min;
        return dp[start][m];
    }

    // Bottom up DP
    private static int findMaxMinOrMinMaxPartition(int[] nums, int m, boolean maxMin) {
        final int[] sums = new int[nums.length + 1];
        final int[][] dp = new int[m + 1][nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int[] row : dp) {
            Arrays.fill(row, maxMin ? 0 : Integer.MAX_VALUE);
        }
        dp[0][0] = maxMin ? Integer.MAX_VALUE : 0;
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= nums.length; col++) {
                for (int k = row - 1; k < col; k++) {
                    dp[row][col] = maxMin
                                   ? Math.max(dp[row][col], Math.min(dp[row - 1][k], sums[col] - sums[k]))
                                   : Math.min(dp[row][col], Math.max(dp[row - 1][k], sums[col] - sums[k]));
                }
            }
        }
        return dp[m][nums.length];
    }

    public static void main(String[] args) {
        System.out.println(minimizeMaximum(new int[] { 7, 2, 5, 10, 8 }, 2));
        System.out.println(minimizeMaximum(new int[] { 6, 3, 2, 8, 7, 5 }, 3));
        System.out.println(minimizeMaximum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 6));
        System.out.println();
        System.out.println(maximizeMinimum(new int[] { 7, 2, 5, 10, 8 }, 2));
        System.out.println(maximizeMinimum(new int[] { 6, 3, 2, 8, 7, 5 }, 3));
        System.out.println(maximizeMinimum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 6));
        System.out.println();
        System.out.println(minMaxR(new int[] { 7, 2, 5, 10, 8 }, 2));
        System.out.println(minMaxR(new int[] { 6, 3, 2, 8, 7, 5 }, 3));
        System.out.println(minMaxR(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 6));
        System.out.println();
        System.out.println(maxMinR(new int[] { 7, 2, 5, 10, 8 }, 2));
        System.out.println(maxMinR(new int[] { 6, 3, 2, 8, 7, 5 }, 3));
        System.out.println(maxMinR(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 6));
        System.out.println();
        System.out.println(minMax(new int[] { 7, 2, 5, 10, 8 }, 2));
        System.out.println(minMax(new int[] { 6, 3, 2, 8, 7, 5 }, 3));
        System.out.println(minMax(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 6));
        System.out.println();
        System.out.println(maxMin(new int[] { 7, 2, 5, 10, 8 }, 2));
        System.out.println(maxMin(new int[] { 6, 3, 2, 8, 7, 5 }, 3));
        System.out.println(maxMin(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 6));
    }
}
