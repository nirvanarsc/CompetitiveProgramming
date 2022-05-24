package leetcode.weekly_contests.weekly_0_99.weekly_67;

import java.util.ArrayList;
import java.util.List;

public class P_763 {

    public List<Integer> partitionLabels(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        final int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[w[i] - 'a'] = i;
        }
        final List<Integer> res = new ArrayList<>();
        int prev = -1;
        int currMax = 0;
        for (int i = 0; i < n; i++) {
            currMax = Math.max(currMax, last[w[i] - 'a']);
            if (currMax == i) {
                res.add(i - prev);
                prev = i;
            }
        }
        return res;
    }
}
