package binarysearch.weekly_32;

public class P_2 {

    public int[] solve(int[] nums) {
        final int n = nums.length;
        final int[] res = new int[n];
        if (n == 0) {
            return res;
        }
        int L = 0;
        int R = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                curr += i;
                R++;
            }
        }
        res[0] = curr;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] == 1) {
                L++;
                R--;
            }
            curr += L;
            curr -= R;
            res[i] = curr;
        }
        return res;
    }
}
