package weekly_contests.weekly_43;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_649 {

    public String predictPartyVictory(String senate) {
        final Deque<Integer> q1 = new ArrayDeque<>();
        final Deque<Integer> q2 = new ArrayDeque<>();
        final int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                q1.offerLast(i);
            } else {
                q2.offerLast(i);
            }
        }
        while (!q1.isEmpty() && !q2.isEmpty()) {
            final int r_index = q1.removeFirst();
            final int d_index = q2.removeFirst();
            if (r_index < d_index) {
                q1.offerLast(r_index + n);
            } else {
                q2.offerLast(d_index + n);
            }
        }
        return q2.isEmpty() ? "Radiant" : "Dire";
    }
}
