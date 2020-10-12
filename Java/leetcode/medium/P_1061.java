package leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import utils.DataStructures.UnionFind;

public class P_1061 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public String smallestEquivalentString(String A, String B, String S) {
        final Map<Character, TreeSet<Character>> map = new HashMap<>();
        final UnionFind uf = new UnionFind(26);
        for (int i = 0; i < A.length(); i++) {
            uf.union(A.charAt(i) - 'a', B.charAt(i) - 'a');
            map.computeIfAbsent((char) (uf.find(A.charAt(i) - 'a') + 'a'),
                                v -> new TreeSet<>()).addAll(Arrays.asList(A.charAt(i), B.charAt(i)));
        }
        final StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            sb.append(map.getOrDefault((char)(uf.find(c-'a')+'a'),
                                       new TreeSet<>(Collections.singletonList(c))).first());
        }
        return sb.toString();
    }
}
