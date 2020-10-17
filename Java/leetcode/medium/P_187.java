package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_187 {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return Collections.emptyList();
        }
        final List<String> res = new ArrayList<>();
        final char[] map = new char[26];
        final int mask = (1 << 20) - 1;
        final byte[] bytes = new byte[1 << 20];
        final char[] chars = s.toCharArray();
        int val = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for (int i = 0; i < 9; i++) {
            val = (val << 2) | map[chars[i] - 'A'];
        }
        for (int i = 9; i < chars.length; i++) {
            val = ((val << 2) & mask) | map[chars[i] - 'A'];
            if (bytes[val] == 1) {
                res.add(String.valueOf(chars, i - 9, 10));
            }
            if (bytes[val] < 2) {
                bytes[val]++;
            }
        }
        return res;
    }

    private static final int MOD = (int) (1e9 + 7);
    private static final int SIZE = 7;

    public List<String> findRepeatedDnaSequencesRollingHash(String s) {
        final Set<String> res = new HashSet<>();
        final Set<Long> seen = new HashSet<>();
        final long pow = (long) Math.pow(SIZE, 10);
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * SIZE + (s.charAt(i) - 'A' + 1)) % MOD;
            if (i >= 10) {
                final long prev = (s.charAt(i - 10) - 'A' + 1) * pow % MOD;
                hash = Math.floorMod(hash - prev, MOD);
            }
            if (i >= 9 && !seen.add(hash)) {
                res.add(s.substring(i - 9, i + 1));
            }
        }
        return new ArrayList<>(res);
    }
}
