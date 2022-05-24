package leetcode.weekly_contests.weekly_100_199.weekly_140;

import java.util.ArrayList;
import java.util.List;

public class P_1078 {

    public static final String[] STRINGS = new String[0];

    public String[] findOccurrences(String text, String first, String second) {
        final String[] words = text.split(" ");
        final List<String> res = new ArrayList<>();
        for (int i = 2; i < words.length; i++) {
            if (first.equals(words[i - 2]) && second.equals(words[i - 1])) {
                res.add(words[i]);
            }
        }
        return res.toArray(STRINGS);
    }
}
