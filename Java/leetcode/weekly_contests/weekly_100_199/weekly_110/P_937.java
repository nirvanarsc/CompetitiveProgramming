package leetcode.weekly_contests.weekly_100_199.weekly_110;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_937 {

    public static final String[] STRINGS = new String[0];

    public String[] reorderLogFiles(String[] logs) {
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            map.put(logs[i], i);
        }
        return Arrays.stream(logs)
                     .sorted((a, b) -> {
                         int i1 = a.indexOf(' ') + 1;
                         int i2 = b.indexOf(' ') + 1;
                         if (Character.isLetter(a.charAt(i1)) && Character.isLetter(b.charAt(i2))) {
                             if (a.substring(i1).equals(b.substring(i2))) {
                                 return a.substring(0, i1 - 1).compareTo(b.substring(0, i2 - 1));
                             }
                             return a.substring(i1).compareTo(b.substring(i2));
                         } else if (Character.isLetter(a.charAt(i1)) || Character.isLetter(b.charAt(i2))) {
                             return Character.isLetter(a.charAt(i1)) ? -1 : 1;
                         } else {
                             return Integer.compare(map.get(a), map.get(b));
                         }
                     })
                     .toArray(String[]::new);
    }
}
