package leetcode.weekly_contests.weekly_111;

public class P_941 {

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int max = -1;
        int maxIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIdx = i;
            }
        }
        if (maxIdx == 0 || maxIdx == arr.length - 1) {
            return false;
        }
        boolean ok = true;
        for (int i = 0; i < maxIdx; i++) {
            ok &= arr[i] < arr[i + 1];
        }
        for (int i = arr.length - 1; i > maxIdx; i--) {
            ok &= arr[i] < arr[i - 1];
        }
        return ok;
    }
}
