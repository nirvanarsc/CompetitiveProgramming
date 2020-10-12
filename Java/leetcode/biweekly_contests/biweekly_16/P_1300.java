package leetcode.biweekly_contests.biweekly_16;

public class P_1300 {

    public static int findBestValue(int[] arr, int target) {
        int start = 1;
        int end = -1;
        for (int num : arr) {
            end = Math.max(end, num);
        }
        while (start <= end) {
            final int mid = start + end >>> 1;
            final int curr = getSum(arr, mid);
            if (curr == target) {
                return mid;
            } else if (curr < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (Math.abs(getSum(arr, start) - target) < Math.abs(getSum(arr, end) - target)) {
            return start;
        }
        return end;
    }

    private static int getSum(int[] arr, int k) {
        int res = 0;
        for (int i : arr) {
            res += Math.min(i, k);
        }
        return res;
    }

    public int findBestValue2(int[] arr, int target) {
        final int average = target / arr.length;
        int sum = 0, count = 0;
        for (int num : arr) {
            if (num <= average) {
                sum += num;
                count += 1;
            }
        }
        if (target - sum == 0) {
            return average;
        }
        final double val = (double) (target - sum) / (arr.length - count);
        final double large = Math.ceil(val);
        final double small = Math.floor(val);
        if (Double.compare(Math.abs(small - val), Math.abs(large - val)) == 0) {
            return (int) small;
        }
        return (int) Math.round(val);
    }

    public static void main(String[] args) {
        System.out.println(findBestValue(new int[] { 4, 9, 3 }, 10));
        System.out.println(findBestValue(new int[] { 2, 3, 5 }, 10));
        System.out.println(findBestValue(new int[] { 60864, 25176, 27249, 21296, 20204 }, 56802));
        System.out.println(findBestValue(new int[] { 60864, 25176, 27249, 21296, 20204 }, 56803));
        System.out.println(findBestValue(new int[] { 1547, 83230, 57084, 93444, 70879 }, 71237));
    }
}
