package leetcode.weekly_contests.weekly_45;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_659 {

    static class Interval {
        int end;
        int length;

        Interval(int end, int length) {
            this.end = end;
            this.length = length;
        }
    }

    public boolean isPossible(int[] nums) {
        final PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end == b.end
                                                                         ? Integer.compare(a.length, b.length)
                                                                         : Integer.compare(a.end, b.end));
        for (int num : nums) {
            while (!pq.isEmpty() && pq.peek().end + 1 < num) {
                if (pq.poll().length < 3) {
                    return false;
                }
            }
            if (pq.isEmpty() || pq.peek().end == num) {
                pq.offer(new Interval(num, 1));
            } else {
                pq.offer(new Interval(num, pq.poll().length + 1));
            }
        }
        while (!pq.isEmpty()) {
            if (pq.poll().length < 3) {
                return false;
            }
        }
        return true;
    }

    public boolean isPossibleHM(int[] nums) {
        final Map<Integer, Integer> freq = new HashMap<>();
        final Map<Integer, Integer> appendfreq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }
        for (int num : nums) {
            if (freq.get(num) == 0) {
                continue;
            }
            if (appendfreq.getOrDefault(num, 0) > 0) {
                appendfreq.merge(num, -1, Integer::sum);
                appendfreq.merge(num + 1, 1, Integer::sum);
            } else if (freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
                freq.merge(num + 1, -1, Integer::sum);
                freq.merge(num + 2, -1, Integer::sum);
                appendfreq.merge(num + 3, 1, Integer::sum);
            } else {
                return false;
            }
            freq.merge(num, -1, Integer::sum);
        }
        return true;
    }
}
