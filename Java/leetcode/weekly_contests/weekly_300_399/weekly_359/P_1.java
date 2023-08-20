package leetcode.weekly_contests.weekly_300_399.weekly_359;

import java.util.List;
import java.util.stream.Collectors;

public class P_1 {

    public boolean isAcronym(List<String> words, String s) {
        return words.stream().map(w -> String.valueOf(w.charAt(0))).collect(Collectors.joining("")).equals(s);
    }
}
