package leetcode.biweekly_contests.biweekly_100_199.biweekly_101;

import java.util.Arrays;

public class P_2 {

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        final int[] v = new int[26];
        Arrays.fill(v, (int) -1e9);
        for (int i = 0; i < chars.length(); i++) {
            v[chars.charAt(i) - 'a'] = vals[i];
        }
        for (int i = 0; i < 26; i++) {
            if (v[i] == (int) -1e9) {
                v[i] = i + 1;
            }
        }
        final int n = s.length();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = v[s.charAt(i) - 'a'];
        }
        return maxSubArrayKadane(arr);
    }

    public int maxSubArrayKadane(int[] nums) {
        int curr = 0;
        int res = 0;
        for (int num : nums) {
            curr = Math.max(num, curr + num);
            res = Math.max(res, curr);
        }
        return res;
    }
}
