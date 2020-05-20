package weekly_contests.weekly_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P_406 {

    public int[][] reconstructQueue(int[][] people) {
        final Comparator<int[]> comparator = (a, b) -> b[0] == a[0] ? Integer.compare(a[1], b[1])
                                                                    : Integer.compare(b[0], a[0]);
        Arrays.sort(people, comparator);
        final List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }

        return res.toArray(new int[people.length][2]);
    }
}
