package leetcode.weekly_contests.weekly_200_299.weekly_234;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_1805 {

    public int numDifferentIntegers(String word) {
        //noinspection DynamicRegexReplaceableByCompiledPattern
        final Set<String> ss = new HashSet<>(Arrays.asList(word.split("[a-z]")));
        ss.remove("");
        final Set<String> next = new HashSet<>();
        for (String w : ss) {
            int i = 0;
            while (i < w.length() && w.charAt(i) == '0') {
                i++;
            }
            next.add(w.substring(i));
        }
        return next.size();
    }
}
