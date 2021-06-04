package binarysearch.weekly_33;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_1 {

    public int solve(int[] nums, int[] multipliers) {
        Arrays.sort(nums);
        Arrays.sort(multipliers);
        final Deque<Integer> num = new ArrayDeque<>();
        for (int nn : nums) {
            num.addFirst(nn);
        }
        final Deque<Integer> mul = new ArrayDeque<>();
        for (int mm : multipliers) {
            mul.addFirst(mm);
        }
        int res = 0;
        while (!num.isEmpty() && !mul.isEmpty()) {
            if (num.getLast() * mul.getLast() > num.getFirst() * mul.getFirst()) {
                res += num.removeLast() * mul.removeLast();
            } else {
                res += num.removeFirst() * mul.removeFirst();
            }
        }
        return res;
    }
}
