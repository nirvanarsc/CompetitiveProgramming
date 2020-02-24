package weekly_143;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_1104 {

    public List<Integer> pathInZigZagTree(int label) {
        int level = 0;
        while (1 << level <= label) {
            ++level;
        }
        final List<Integer> res = new ArrayList<>();
        for (; label >= 1; label /= 2, --level) {
            res.add(label);
            label = (1 << level) - 1 - label + (1 << (level - 1));
        }
        Collections.reverse(res);
        return res;
    }
}
