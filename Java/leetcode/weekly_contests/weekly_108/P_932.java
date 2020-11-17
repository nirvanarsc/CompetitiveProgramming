package leetcode.weekly_contests.weekly_108;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_932 {

    public int[] beautifulArray(int N) {
        List<Integer> res = new ArrayList<>(Collections.singleton(1));
        while (res.size() < N) {
            final List<Integer> tmp = new ArrayList<>();
            for (int i : res) { if (i * 2 - 1 <= N) { tmp.add(i * 2 - 1); } }
            for (int i : res) { if (i * 2 <= N) { tmp.add(i * 2); } }
            res = tmp;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
