package weekly_contests.weekly_128;

import java.util.ArrayList;
import java.util.List;

public class P_1009 {

    public int bitwiseComplement(int N) {
        if (N == 0) { return 1; }
        final List<Integer> ints = new ArrayList<>();
        int res = 0;
        while (N != 0) {
            ints.add(N % 2 == 0 ? 1 : 0);
            N >>= 1;
        }
        for (int i = ints.size() - 1; i >= 0; i--) {
            res = (res << 1) + ints.get(i);
        }
        return res;
    }
}
