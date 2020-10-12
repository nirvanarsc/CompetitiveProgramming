package leetcode.weekly_contests.weekly_181;

import java.util.LinkedList;

public class P_1389 {

    public int[] createTargetArray(int[] nums, int[] index) {
        final LinkedList<Integer> l = new LinkedList<>();
        for (int i = 0; i < index.length; i++) {
            l.add(index[i], nums[i]);
        }
        return l.stream().mapToInt(Integer::intValue).toArray();
    }
}
