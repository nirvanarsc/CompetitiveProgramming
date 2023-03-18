package leetcode.biweekly_contests.biweekly_0_99.biweekly_43;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class P_1719 {

    public int solve(int[][] pairs) {
        final BitSet[] sets = new BitSet[500];
        for (int i = 0; i < 500; i++) {
            sets[i] = new BitSet(500);
            sets[i].set(i, true);
        }
        final Set<Integer> nodes = new HashSet<>();
        for (int[] p : pairs) {
            final int u = p[0] - 1;
            final int v = p[1] - 1;
            sets[u].set(v, true);
            sets[v].set(u, true);
            nodes.add(u);
            nodes.add(v);
        }
        boolean hasRoot = false;
        for (BitSet set : sets) {
            if (set.cardinality() == nodes.size()) {
                hasRoot = true;
                break;
            }
        }
        if (!hasRoot) {
            return 0;
        }
        boolean multiple = false;
        for (int[] p : pairs) {
            final int u = p[0] - 1;
            final int v = p[1] - 1;
            final BitSet set1 = sets[u];
            final BitSet set2 = sets[v];
            final BitSet or = new BitSet(500);
            or.or(set1);
            or.or(set2);
            final boolean oneSuper = set1.equals(or);
            final boolean twoSuper = set2.equals(or);
            if (oneSuper && twoSuper) {
                multiple = true;
            } else if (!oneSuper && !twoSuper) {
                return 0;
            }
        }
        return multiple ? 2 : 1;
    }
}
