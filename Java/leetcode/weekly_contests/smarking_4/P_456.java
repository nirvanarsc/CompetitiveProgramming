package leetcode.weekly_contests.smarking_4;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_456 {

    public boolean find132patternStack(int[] nums) {
        final Deque<Integer> stack = new ArrayDeque<>();
        int max = (int) -1e9;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekFirst() < nums[i]) {
                max = stack.removeFirst();
            }
            if (nums[i] > max) { stack.addFirst(nums[i]); }
            if (nums[i] < max) { return true; }
        }
        return false;
    }

    public boolean find132pattern(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            final int target = nums[i];
            int peek = target;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > target) {
                    if (peek > nums[j]) {
                        return true;
                    } else {
                        peek = nums[j];
                    }
                }
            }
        }
        return false;
    }
}
