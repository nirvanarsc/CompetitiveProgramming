package leetcode.biweekly_contests.biweekly_0_99.biweekly_6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P_1153 {

    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) { return true; }
        final Map<Character, Character> dp = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (dp.containsKey(str1.charAt(i)) && dp.get(str1.charAt(i)) != str2.charAt(i)) {
                return false;
            }
            dp.put(str1.charAt(i), str2.charAt(i));
        }
        return new HashSet<>(dp.values()).size() < 26;
    }

    public boolean canConvertVerbose(String str1, String str2) {
        if (str1.equals(str2)) { return true; }
        if (getFrequency(str2) == 26) { return false; }
        final Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            final char c1 = str1.charAt(i);
            final char c2 = str2.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            map.put(c1, c2);
        }
        return true;
    }

    private static int getFrequency(String str) {
        final int[] map = new int[26];
        int res = 0;
        for (char c : str.toCharArray()) {
            if (map[c - 'a'] == 0) {
                res++;
            }
            map[c - 'a'] = 1;
        }
        return res;
    }
}
