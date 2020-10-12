package leetcode.biweekly_contests.biweekly_11;

public class P_1228 {

    public int missingNumber(int[] arr) {
        final int i = (arr[arr.length - 1] - arr[0]) / arr.length;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] + i != arr[j + 1]) {
                return arr[j] + i;
            }
        }
        return 0;
    }
}
