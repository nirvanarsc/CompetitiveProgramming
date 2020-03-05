package weekly_contests.weekly_117;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_967 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> curr = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 1; i < N; i++) {
            final List<Integer> next = new ArrayList<>();
            for (int x : curr) {
                final int y = x % 10;
                if (x > 0 && y + K < 10) { next.add(x * 10 + y + K); }
                if (x > 0 && K > 0 && y - K >= 0) { next.add(x * 10 + y - K); }
            }
            curr = next;
        }
        return curr.stream().mapToInt(j -> j).toArray();
    }
}
