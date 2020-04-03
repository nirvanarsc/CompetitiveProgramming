package weekly_contests.weekly_66;

import java.util.ArrayList;
import java.util.List;

public class P_759 {

    static class Interval {
        public int start;
        public int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Pair {
        int t;
        boolean isStart;

        Pair(int t, boolean isStart) {
            this.t = t;
            this.isStart = isStart;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        final List<Pair> p = new ArrayList<>();
        for (List<Interval> l : schedule) {
            for (Interval i : l) {
                p.add(new Pair(i.start, true));
                p.add(new Pair(i.end, false));
            }
        }
        p.sort((a, b) -> a.t == b.t ? Boolean.compare(a.isStart, b.isStart) : Integer.compare(a.t, b.t));
        final List<Interval> res = new ArrayList<>();
        int open = 0;
        int prev = Integer.MAX_VALUE;
        for (Pair curr : p) {
            if (open == 0) {
                if (prev != Integer.MAX_VALUE) {
                    if (prev != curr.t) {
                        res.add(new Interval(prev, curr.t));
                    } else {
                        prev = Integer.MAX_VALUE;
                    }
                }
            }
            open += curr.isStart ? 1 : -1;
            if (open == 0) {
                prev = curr.t;
            }
        }
        return res;
    }
}
