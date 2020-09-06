package biweekly_contests.biweekly_34;

public class P_1574 {

    public int findLengthOfShortestSubarray(int[] arr) {
        final int n = arr.length;
        int i = 0, j = n - 1;
        while (i + 1 < n && arr[i] <= arr[i + 1]) { i++; }
        if (i == j) {
            return 0;
        }
        while (j > 0 && arr[j] >= arr[j - 1]) { j--; }
        return Math.min(goUp(arr, i, j), goDown(arr, i, j));
    }

    private static int goDown(int[] arr, int i, int j) {
        while (i >= 0 && arr[i] > arr[j]) {
            i--;
        }
        return j - i - 1;
    }

    private static int goUp(int[] arr, int i, int j) {
        while (j < arr.length && arr[i] > arr[j]) {
            j++;
        }
        return j - i - 1;
    }
}
