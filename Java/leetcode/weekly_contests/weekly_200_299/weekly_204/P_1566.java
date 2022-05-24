package leetcode.weekly_contests.weekly_200_299.weekly_204;

public class P_1566 {

    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i <= arr.length - m * k; i++) {
            boolean ok = true;
            for (int times = 0, j = i + m; times < m * (k - 1); j++, times++) {
                if (arr[j] != arr[j - m]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return true;
            }
        }
        return false;
    }
}
