package weekly_contests.weekly_99;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import utils.DataStructures.UnionFind;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_893 {

    public int numSpecialEquivGroups(String[] A) {
        final Set<Integer> seen = new HashSet<>();
        for (String S : A) {
            final int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i) {
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            seen.add(Arrays.hashCode(count));
        }
        return seen.size();
    }

    public int numSpecialEquivGroupsUF(String[] A) {
        final UnionFind uf = new UnionFind(A.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (isEquiv(A[i], A[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }

    private static boolean isEquiv(String a, String b) {
        final int[] map1 = new int[26];
        final int[] map2 = new int[26];
        for (int i = 0; i < a.length(); i++) {
            if (i % 2 == 0) { map1[a.charAt(i) - 'a']++; } else { map2[a.charAt(i) - 'a']++; }
        }
        for (int i = 0; i < a.length(); i++) {
            if (i % 2 == 0) { map1[b.charAt(i) - 'a']--; } else { map2[b.charAt(i) - 'a']--; }
        }
        for (int i = 0; i < 26; i++) {
            if (map1[i] != 0 || map2[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
