package weekly_contests.weekly_41;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class P_636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        final int[] res = new int[n];
        final Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;
        for (String log : logs) {
            final String[] parts = log.split(":");
            final int currTime = Integer.parseInt(parts[2]);
            if (!stack.isEmpty()) {
                res[stack.peekFirst()] += currTime - prevTime;
            }
            prevTime = currTime;
            if ("start".equals(parts[1])) {
                stack.addFirst(Integer.parseInt(parts[0]));
            } else {
                res[stack.removeFirst()]++;
                prevTime++;
            }
        }
        return res;
    }
}
