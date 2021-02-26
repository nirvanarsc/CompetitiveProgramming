package leetcode.weekly_contests.weekly_112;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        final Deque<Integer> dq = new ArrayDeque<>();
        int j = 0;
        for (int num : pushed) {
            dq.addFirst(num);
            while (!dq.isEmpty() && dq.getFirst() == popped[j]) {
                dq.removeFirst();
                j++;
            }
        }
        return dq.isEmpty();
    }
}
