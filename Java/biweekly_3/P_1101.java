package biweekly_3;

import java.util.Arrays;
import java.util.Comparator;

import utils.DataStructures.UnionFind;

public class P_1101 {

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        final UnionFind uf = new UnionFind(n);
        for (int[] log : logs) {
            if (uf.find(log[1]) != uf.find(log[2])) {
                uf.union(log[1], log[2]);
            }
            if (uf.count() == 1) {
                return log[0];
            }
        }
        return - 1;
    }
}
