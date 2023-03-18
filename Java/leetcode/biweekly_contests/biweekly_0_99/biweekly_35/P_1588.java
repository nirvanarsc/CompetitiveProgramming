package leetcode.biweekly_contests.biweekly_0_99.biweekly_35;

public class P_1588 {

    public int sumOddLengthSubarrays(int[] arr) {
        final int l = arr.length;
        int res = 0;
        for (int i = 1; i <= l; i += 2) {
            int j = 0;
            int window = i - 1;
            int curr = 0;
            for (int k = 0; k < arr.length; k++, window--) {
                curr += arr[k];
                if (window == 0) {
                    res += curr;
                    curr -= arr[j++];
                    window++;
                }
            }
        }
        return res;
    }
}
