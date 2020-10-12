package leetcode.weekly_contests.weekly_27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_554 {

    static class Interval {
        int time;
        boolean isStart;

        Interval(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    public int leastBricksLineSweep(List<List<Integer>> wall) {
        final List<Interval> intervals = new ArrayList<>();
        int max = 0;
        for (List<Integer> row : wall) {
            int prev = 0;
            for (int num : row) {
                intervals.add(new Interval(prev, true));
                intervals.add(new Interval(prev + num, false));
                max = Math.max(max, prev + num);
                prev += num;
            }
        }
        intervals.sort((a, b) -> a.time == b.time ? Boolean.compare(a.isStart, b.isStart)
                                                  : Integer.compare(a.time, b.time));

        int res = wall.size();
        int curr = 0;
        for (Interval i : intervals) {
            curr += i.isStart ? 1 : -1;
            if (i.time > 0 && i.time < max) {
                res = Math.min(res, curr);
            }
        }
        return res;
    }

    public int leastBricks(List<List<Integer>> wall) {
        int count = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int length = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                length += list.get(i);
                final int currCount = map.merge(length, 1, Integer::sum);
                count = Math.max(count, currCount);
            }
        }
        return wall.size() - count;
    }
}
