package weekly_contests.weekly_60;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_735 {

    public int[] asteroidCollision(int[] asteroids) {
        final Deque<Integer> stack = new ArrayDeque<>();
        for (int ast : asteroids) {
            if (ast > 0) {
                stack.addFirst(ast);
            } else {
                while (!stack.isEmpty() && stack.peekFirst() > 0 && -ast > stack.peekFirst()) {
                    stack.removeFirst();
                }
                if (stack.isEmpty()) {
                    stack.addFirst(ast);
                } else {
                    if (stack.peekFirst() < 0) {
                        stack.addFirst(ast);
                    } else if (stack.peekFirst() == -ast) {
                        stack.removeFirst();
                    }
                }
            }
        }
        final int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }
}
