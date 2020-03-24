package weekly_contests.weekly_85;

import java.util.ArrayList;
import java.util.List;

import utils.DataStructures.UnionFind;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_839 {

    public int numSimilarGroups(String[] A) {
        final UnionFind uf = new UnionFind(A.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (buddyStrings(A[i], A[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            return true;
        }
        final List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                diff.add(i);
            }
            if (diff.size() > 2) {
                return false;
            }
        }
        return diff.size() == 2 &&
               A.charAt(diff.get(0)) == B.charAt(diff.get(1)) &&
               A.charAt(diff.get(1)) == B.charAt(diff.get(0));
    }
}
