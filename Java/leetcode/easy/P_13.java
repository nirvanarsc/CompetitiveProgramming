package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class P_13 {

    private static final Map<Character, Integer> MAP = new HashMap<>();

    static {
        MAP.put('I', 1);
        MAP.put('V', 5);
        MAP.put('X', 10);
        MAP.put('L', 50);
        MAP.put('C', 100);
        MAP.put('D', 500);
        MAP.put('M', 1000);
    }

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 || MAP.get(s.charAt(i + 1)) <= MAP.get(s.charAt(i))) {
                res += MAP.get(s.charAt(i));
            } else {
                res -= MAP.get(s.charAt(i));
            }
        }
        return res;
    }
}
