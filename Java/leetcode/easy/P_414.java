package leetcode.easy;

import java.util.TreeSet;

public class P_414 {

    public int thirdMax(int[] nums) {
        final TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.pollFirst();
            }
        }
        return set.size() == 3 ? set.first() : set.last();
    }
}
