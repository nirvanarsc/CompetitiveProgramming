package leetcode.weekly_contests.weekly_160;

import java.util.List;

public class P_1239 {

    static int[] masks;
    static int n;

    public int maxLength(List<String> arr) {
        n = arr.size();
        masks = new int[n];
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            int mask = 0;
            for (char c : arr.get(i).toCharArray()) {
                if ((mask & (1 << (c - 'a'))) != 0) {
                    ok = false;
                    break;
                }
                mask |= 1 << (c - 'a');
            }
            if (ok) {
                masks[i] = mask;
            }
        }
        int res = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            boolean ok = true;
            int curr = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    if ((curr & masks[i]) != 0) {
                        ok = false;
                        break;
                    }
                    curr |= masks[i];
                }
            }
            if (ok) {
                res = Math.max(res, Integer.bitCount(curr));
            }
        }
        return res;
    }
}
