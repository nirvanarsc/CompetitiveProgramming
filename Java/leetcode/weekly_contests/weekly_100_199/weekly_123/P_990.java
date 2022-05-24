package leetcode.weekly_contests.weekly_100_199.weekly_123;

import utils.DataStructures.UnionFind;

public class P_990 {

    public boolean equationsPossible(String[] equations) {
        final UnionFind uf = new UnionFind(26);
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                uf.union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if (uf.find(s.charAt(0) - 'a') == uf.find(s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }
}
