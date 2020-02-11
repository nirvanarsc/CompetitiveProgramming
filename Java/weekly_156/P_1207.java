package weekly_156;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P_1207 {

    public boolean uniqueOccurrences(int[] arr) {
        final Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) {
            count.merge(num, 1, Integer::sum);
        }
        return count.size() == new HashSet<>(count.values()).size();
    }
}
