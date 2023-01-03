package leetcode.biweekly_contests.biweekly_94;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P_2 {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report,
                                     int[] student_id, int k) {
        final int n = student_id.length;
        final Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        final Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));
        return IntStream.range(0, n)
                        .mapToObj(i -> {
                            int score = 0;
                            for (String w : report[i].split(" ")) {
                                if (positive.contains(w)) {
                                    score += 3;
                                } else if (negative.contains(w)) {
                                    score -= 1;
                                }
                            }
                            return new int[] { student_id[i], score };
                        })
                        .sorted((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0])
                                                       : Integer.compare(b[1], a[1]))
                        .map(i -> i[0])
                        .limit(k)
                        .collect(Collectors.toList());
    }
}
