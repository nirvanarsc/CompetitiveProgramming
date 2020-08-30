package weekly_contests.weekly_204;

public class P_1566 {

    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i <= arr.length - (m * k); i++) {
            if (check(arr, m, k, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(int[] arr, int m, int k, int i) {
        for (int j = i + m, idx = i; j < i + m * k; j++, idx++) {
            if (arr[j] != arr[idx]) {
                return false;
            }
        }
        return true;
    }
}
