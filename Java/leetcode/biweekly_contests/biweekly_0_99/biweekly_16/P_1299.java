package leetcode.biweekly_contests.biweekly_0_99.biweekly_16;

public class P_1299 {

    public int[] replaceElements(int[] arr) {
        int greatest = -1;
        for (int i = arr.length - 1; i >= 0; --i) {
            final int temp = arr[i];
            arr[i] = greatest;
            greatest = Math.max(greatest, temp);
        }
        return arr;
    }

    public int[] replaceElements2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getMax(arr, i + 1);
        }
        return arr;
    }

    private static int getMax(int[] arr, int from) {
        int res = -1;
        for (int i = from; i < arr.length; i++) {
            res = Math.max(arr[i], res);
        }
        return res;
    }
}
