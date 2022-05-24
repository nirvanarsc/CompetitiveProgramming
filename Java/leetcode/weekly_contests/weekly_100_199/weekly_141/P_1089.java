package leetcode.weekly_contests.weekly_100_199.weekly_141;

public class P_1089 {

    public void duplicateZeros(int[] arr) {
        int numZeroes = 0;
        for (int value : arr) {
            if (value == 0) {
                numZeroes++;
            }
        }

        for (int i = arr.length - 1, j = i + numZeroes; i < j; i--, j--) {
            if (arr[i] == 0) {
                if (j < arr.length) {
                    arr[j] = 0;
                }
                j--;
                if (j < arr.length) {
                    arr[j] = 0;
                }
            } else {
                if (j < arr.length) {
                    arr[j] = arr[i];
                }
            }
        }
    }
}
