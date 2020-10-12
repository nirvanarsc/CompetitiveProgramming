package leetcode.biweekly_contests.biweekly_19;

public class P_1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0, i = 0;
        final int div = k;
        double sum = 0;
        for (int value : arr) {
            k--;
            sum += value;
            if (k == 0) {
                k++;
                if (sum / div >= threshold) {
                    res++;
                }
                sum -= arr[i++];
            }
        }
        return res;
    }
}
