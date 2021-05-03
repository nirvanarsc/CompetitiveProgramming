package gcj.year_2020.qualifying;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class ParentingPartneringReturns {

    static class Interval {
        int time;
        boolean isStart;
        int end;
        Character person;

        Interval(int time, boolean isStart, int end) {
            this.time = time;
            this.isStart = isStart;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            final int inputs = in.nextInt();
            final List<Interval> intervals = new ArrayList<>();
            for (int j = 0; j < inputs; j++) {
                final int start = in.nextInt();
                final int end = in.nextInt();
                intervals.add(new Interval(start, true, end));
                intervals.add(new Interval(end, false, end));
            }
            final List<Interval> copy = new ArrayList<>(intervals);
            copy.sort((a, b) -> a.time == b.time ? Boolean.compare(a.isStart, b.isStart)
                                                 : Integer.compare(a.time, b.time));
            int c = -1;
            int j = -1;
            final StringBuilder sb = new StringBuilder();
            boolean hasSolution = true;
            for (Interval curr : copy) {
                if (curr.isStart) {
                    if (c == -1) {
                        curr.person = 'C';
                        c = curr.end;
                    } else if (j == -1) {
                        curr.person = 'J';
                        j = curr.end;
                    } else {
                        hasSolution = false;
                        break;
                    }
                } else {
                    if (c == curr.end) {
                        c = -1;
                    }
                    if (j == curr.end) {
                        j = -1;
                    }
                }
            }
            if (hasSolution) {
                for (Interval curr : intervals) {
                    if (curr.person != null) {
                        sb.append(curr.person);
                    }
                }
            }
            final String res = hasSolution ? sb.toString() : "IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + res);
        }
    }
}
