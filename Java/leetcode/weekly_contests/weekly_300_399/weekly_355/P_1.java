package leetcode.weekly_contests.weekly_300_399.weekly_355;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P_1 {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        final String regex = new StringBuilder().append('\\').append(separator).toString();
        return words.stream()
                    .flatMap(word -> Arrays.stream(word.split(regex)))
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.toList());
    }
}
