package leetcode.weekly_contests.weekly_235;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P_1816 {

    public String truncateSentence(String s, int k) {
        return Arrays.stream(s.split(" ")).limit(k).collect(Collectors.joining(" "));
    }
}
