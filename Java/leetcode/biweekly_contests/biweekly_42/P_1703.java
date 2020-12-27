package leetcode.biweekly_contests.biweekly_42;

import java.util.ArrayList;
import java.util.List;

public class P_1703 {

    public int minMoves(int[] nums, int k) {
        final List<Integer> one = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                one.add(i);
            }
        }
        for (int i = 0; i < one.size(); i++) {
            one.set(i, one.get(i) - i);
        }
        final int ll = k / 2;
        final int rr = k - 1 - ll;
        int currL = 0;
        int currR = 0;
        for (int i = 0; i < ll; i++) {
            currL += one.get(ll) - one.get(i);
        }
        for (int i = ll + 1; i < k; i++) {
            currR += one.get(i) - one.get(ll);
        }
        int res = currL + currR;
        for (int i = 1; i <= one.size() - k; i++) {
            currL -= one.get(i - 1 + ll) - one.get(i - 1);
            currL += (one.get(i + ll) - one.get(i - 1 + ll)) * ll;

            currR -= (one.get(i + ll) - one.get(i + ll - 1)) * rr;
            currR += one.get(i + k - 1) - one.get(i + ll);
            System.out.println(currL + currR);
            res = Math.min(currL + currR, res);
        }
        return res;
    }
}
