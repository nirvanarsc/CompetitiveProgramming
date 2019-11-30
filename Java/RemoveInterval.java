import java.util.ArrayList;
import java.util.List;

public final class RemoveInterval {

    public static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        final int rStart = toBeRemoved[0];
        final int rEnd = toBeRemoved[1];

        final List<List<Integer>> res = new ArrayList<>();
        for (int[] interval : intervals) {
            final int start = interval[0];
            final int end = interval[1];

            if (end <= rStart || rEnd <= start) {
                final List<Integer> curr = new ArrayList<>();
                curr.add(start);
                curr.add(end);
                res.add(curr);
            }
            if (start < rStart && rEnd < end) {
                final List<Integer> first = new ArrayList<>();
                final List<Integer> second = new ArrayList<>();
                first.add(start);
                first.add(rStart);
                second.add(rEnd);
                second.add(end);
                res.add(first);
                res.add(second);
            } else if (start <= rStart && rStart < end && end < rEnd) {
                final List<Integer> curr = new ArrayList<>();
                curr.add(start);
                curr.add(rStart);
                res.add(curr);
            } else if (rStart <= start && start < rEnd && rEnd < end) {
                final List<Integer> curr = new ArrayList<>();
                curr.add(rEnd);
                curr.add(end);
                res.add(curr);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        final int[][] intervals1 = { { 0, 2 }, { 3, 4 }, { 5, 7 } };
        final int[][] intervals2 = { { -5, -4 }, { -3, -2 }, { 1, 2 }, { 3, 5 }, { 8, 9 }, };
        removeInterval(intervals1, new int[] { 1, 6 }).forEach(System.out::println);
        System.out.println();
        removeInterval(intervals2, new int[] { -1, 4 }).forEach(System.out::println);
        System.out.println();
        removeInterval(new int[][] { { 0, 5 }, }, new int[] { 2, 3 }).forEach(System.out::println);
        System.out.println();
        removeInterval(new int[][] { { 0, 100 }, }, new int[] { 0, 50 }).forEach(System.out::println);
    }

    private RemoveInterval() {}
}
