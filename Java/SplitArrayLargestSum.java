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

    public static void main(String[] args) {
        System.out.println(splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
        System.out.println(splitArray(new int[] { 6, 3, 2, 8, 7, 5 }, 3));
        System.out.println(splitArray(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 6));
    }

    private SplitArrayLargestSum() {}
}
