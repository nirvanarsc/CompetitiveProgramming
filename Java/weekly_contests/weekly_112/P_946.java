package weekly_contests.weekly_112;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        final Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int x : pushed) {
            stack.addFirst(x);
            while (!stack.isEmpty() && stack.peekFirst() == popped[j]) {
                stack.removeFirst();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
