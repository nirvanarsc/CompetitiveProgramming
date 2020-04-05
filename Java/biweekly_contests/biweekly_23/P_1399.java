package biweekly_contests.biweekly_23;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_1399 {

    public int countLargestGroup(int n) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.merge(sum(i), 1, Integer::sum);
        }
        return Collections.frequency(map.values(), Collections.max(map.values()));
    }

    private static int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
