package leetcode.weekly_contests.weekly_254;

import java.util.TreeSet;

@SuppressWarnings("ConstantConditions")
public class P_2 {

    public int[] rearrangeArray(int[] nums) {
        final TreeSet<Integer> ts = new TreeSet<>();
        for (int num : nums) {
            ts.add(num);
        }
        final int n = nums.length;
        final int[] res = new int[n];
        for (int i = 0; i < n; i += 2) {
            res[i] = ts.pollLast();
        }
        for (int i = 1; i < n; i += 2) {
            res[i] = ts.pollFirst();
        }
        return res;
    }
}
