package leetcode.weekly_contests.weekly_214;

public class P_1646 {

    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        final int[] arr = new int[n + 1];
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i / 2] + arr[(i / 2) + 1];
            }
        }
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }
}
