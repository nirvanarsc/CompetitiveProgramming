package leetcode.weekly_contests.weekly_195;

import java.util.HashSet;
import java.util.Set;

public class P_1496 {

    public boolean isPathCrossing(String path) {
        int i = 0;
        int j = 0;
        final Set<String> set = new HashSet<>();
        set.add(i + "," + j);
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                i += 1;
            } else if (c == 'S') {
                i -= 1;
            } else if (c == 'E') {
                j += 1;
            } else {
                j -= 1;
            }
            if (!set.add(i + "," + j)) {
                return true;
            }
        }
        return false;
    }
}
