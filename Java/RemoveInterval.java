import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class RemoveInterval {

    public static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        final List<List<Integer>> res = new ArrayList<>();
        final int rStart = toBeRemoved[0];
        final int rEnd = toBeRemoved[1];

        for (int[] interval : intervals) {
            final int start = interval[0];
            final int end = interval[1];

            if (end <= rStart || rEnd <= start) {
                res.add(Arrays.asList(start, end));
            } else if (start < rStart && rEnd < end) {
                res.add(Arrays.asList(start, rStart));
                res.add(Arrays.asList(rEnd, end));
            } else if (start < rStart && end < rEnd) {
                res.add(Arrays.asList(start, rStart));
            } else if (rStart <= start && rEnd < end) {
                res.add(Arrays.asList(rEnd, end));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeInterval(new int[][] { { 0, 2 }, { 3, 4 }, { 5, 7 } }, new int[] { 1, 6 }));
        System.out.println(removeInterval(new int[][] { { -5, -4 }, { -3, -2 }, { 1, 2 }, { 3, 5 }, { 8, 9 } },
                                          new int[] { -1, 4 }));
        System.out.println(removeInterval(new int[][] { { 0, 5 }, }, new int[] { 2, 3 }));
        System.out.println(removeInterval(new int[][] { { 0, 100 }, }, new int[] { 0, 50 }));
    }

    private RemoveInterval() {}
}
