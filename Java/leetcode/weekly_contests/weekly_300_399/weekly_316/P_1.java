package leetcode.weekly_contests.weekly_300_399.weekly_316;

public class P_1 {

    public boolean haveConflict(String[] event1, String[] event2) {
        return overlaps(new int[] { f(event1[0]), f(event1[1]) },
                        new int[] { f(event2[0]), f(event2[1]) });
    }

    private static int f(String w) {
        return Integer.parseInt(w.substring(0, 2)) * 60 + Integer.parseInt(w.substring(3, 5));
    }

    private static boolean overlaps(int[] left, int[] right) {
        return !(left[1] < right[0] || right[1] < left[0]);
    }
}
