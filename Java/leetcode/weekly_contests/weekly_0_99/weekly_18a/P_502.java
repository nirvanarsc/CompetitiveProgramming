package leetcode.weekly_contests.weekly_0_99.weekly_18a;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_502 {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        final PriorityQueue<int[]> profit = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        final PriorityQueue<int[]> capital = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < Profits.length; i++) {
            capital.add(new int[] { Capital[i], Profits[i] });
        }
        for (int i = 0; i < k; i++) {
            while (!capital.isEmpty() && capital.peek()[0] <= W) {
                profit.add(capital.remove());
            }

            if (profit.isEmpty()) {
                break;
            }
            W += profit.remove()[1];
        }
        return W;
    }
}
