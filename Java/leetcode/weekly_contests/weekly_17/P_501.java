package leetcode.weekly_contests.weekly_17;

import java.util.ArrayList;
import java.util.List;

import utils.BSTIterator;
import utils.DataStructures.TreeNode;

public class P_501 {

    public int[] findMode(TreeNode root) {
        final BSTIterator left = new BSTIterator(root, true);
        Integer prev = null;
        final List<Integer> res = new ArrayList<>();
        int maxFreq = 1;
        int currFreq = 1;
        while (left.hasNext()) {
            final int curr = left.next();
            if (prev != null && curr == prev) {
                currFreq++;
            } else {
                currFreq = 1;
            }
            if (currFreq > maxFreq) {
                maxFreq = currFreq;
                res.clear();
            }
            if (currFreq == maxFreq) {
                res.add(curr);
            }
            prev = curr;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
