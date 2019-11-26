public final class SplitArrayLargestSum {

    public static int splitArray(int[] nums, int m) {
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

    public static int minSweetness(int[] chocolate, int m) {
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

    // TODO Write bottom-up DP
    public static int splitArrayDP(int[] nums, int m) {
        final int[][] dp = new int[nums.length][m + 1];
        final int[] sum = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            sum[i] = (i == nums.length - 1 ? 0 : sum[i + 1]) + nums[i];
        }
        return calc(nums, 0, m, sum, dp);
    }

    private static int calc(int[] nums, int start, int m, int[] sums, int[][] dp) {
        if (m == 1) {
            return sums[start];
        }
        if (dp[start][m] > 0) {
            return dp[start][m];
        }
        int min = Integer.MAX_VALUE, sum = 0;
        for (int i = start; i <= nums.length - m; i++) {
            sum += nums[i];
            min = Math.min(Math.max(sum, calc(nums, i + 1, m - 1, sums, dp)), min);
        }
        dp[start][m] = min;
        return dp[start][m];
    }

    public static int findMaxMinPartition(int[] nums, int m) {
        final int[][] dp = new int[nums.length + 1][m + 1];
        dp[0][0] = Integer.MAX_VALUE;
        for (int n = 1; n <= nums.length; n++) {
            for (int k = 1; k <= m; k++) {
                int curr = 0;
                for (int j = n - 1; j >= k - 1; j--) {
                    curr += nums[j];
                    dp[n][k] = Math.max(dp[n][k], Math.min(dp[j][k - 1], curr));
                }
            }
        }
        return dp[nums.length][m];
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
        System.out.println(splitArray(new int[] { 6, 3, 2, 8, 7, 5 }, 3));
        System.out.println(splitArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 6));
        System.out.println();
        System.out.println(splitArrayDP(new int[] { 7, 2, 5, 10, 8 }, 2));
        System.out.println(splitArrayDP(new int[] { 6, 3, 2, 8, 7, 5 }, 3));
        System.out.println(splitArrayDP(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 6));
        System.out.println();
        System.out.println(minSweetness(new int[] { 7, 2, 5, 10, 8 }, 2));
        System.out.println(minSweetness(new int[] { 6, 3, 2, 8, 7, 5 }, 3));
        System.out.println(minSweetness(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 6));
        System.out.println();
        System.out.println(findMaxMinPartition(new int[] { 7, 2, 5, 10, 8 }, 2));
        System.out.println(findMaxMinPartition(new int[] { 6, 3, 2, 8, 7, 5 }, 3));
        System.out.println(findMaxMinPartition(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 6));
    }

    private SplitArrayLargestSum() {}
}
