package biweekly_contests.biweekly_11;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P_1229 {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        int j = 0;
        while (i < slots1.length && j < slots2.length) {
            if (Math.min(slots1[i][1], slots2[j][1]) - Math.max(slots1[i][0], slots2[j][0]) >= duration) {
                return Arrays.asList(Math.max(slots1[i][0], slots2[j][0]),
                                     Math.max(slots1[i][0], slots2[j][0]) + duration);
            }
            else if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return Collections.emptyList();
    }
}
