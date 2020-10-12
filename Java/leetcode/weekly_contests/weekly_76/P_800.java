package leetcode.weekly_contests.weekly_76;

import java.util.HashMap;
import java.util.Map;

public class P_800 {

    static final String[] nums = {
            "00", "11", "22", "33", "44", "55", "66", "77",
            "88", "99", "aa", "bb", "cc", "dd", "ee", "ff"
    };

    static final Map<String, Integer> map = new HashMap<>();

    static {
        for (String str : nums) {
            map.put(str, Integer.parseInt(str, 16));
        }
    }

    private static String findNearest(String str) {
        final int x = Integer.parseInt(str, 16);
        int min = Integer.MAX_VALUE;
        String res = "";
        for (String num : nums) {
            final int n = map.get(num);
            if (Math.abs(x - n) < min) {
                min = Math.abs(x - n);
                res = num;
            }
        }
        return res;
    }

    public String similarRGB(String color) {
        return '#' + findNearest(color.substring(1, 3))
               + findNearest(color.substring(3, 5))
               + findNearest(color.substring(5, 7));
    }
}
