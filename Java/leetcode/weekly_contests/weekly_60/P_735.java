package leetcode.weekly_contests.weekly_60;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P_735 {

    public int[] asteroidCollision(int[] asteroids) {
        final Deque<Integer> dq = new ArrayDeque<>();
        final List<Integer> res = new ArrayList<>();
        for (int a : asteroids) {
            if (a < 0) {
                while (!dq.isEmpty() && dq.getFirst() < Math.abs(a)) {
                    dq.removeFirst();
                }
                if (!dq.isEmpty() && dq.getFirst() == Math.abs(a)) {
                    dq.removeFirst();
                } else if (dq.isEmpty()) {
                    res.add(a);
                }
            } else {
                dq.addFirst(a);
            }
        }
        while (!dq.isEmpty()) {
            res.add(dq.removeLast());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
