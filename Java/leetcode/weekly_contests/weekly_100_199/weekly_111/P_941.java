package leetcode.weekly_contests.weekly_100_199.weekly_111;

public class P_941 {

    public boolean validMountainArray(int[] arr) {
        final int n = arr.length;
        int peak = 0;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] == arr[i] || arr[i] == arr[i + 1]) {
                return false;
            }
            if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
                return false;
            }
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                peak++;
            }
        }
        return peak == 1;
    }
}
