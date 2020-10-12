package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class P_187 {

    public List<String> findRepeatedDnaSequences(String s) {
        final Set<String> res = new HashSet<>();
        final Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            final String sub = s.substring(i, i + 10);
            if (!set.add(sub)) {
                res.add(sub);
            }
        }
        return new ArrayList<>(res);
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        final Map<String, Integer> map = new HashMap<>();
        final List<String> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            map.merge(s.substring(i, i + 10), 1, Integer::sum);
        }
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public List<String> findRepeatedDnaSequences3(String s) {
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
}
