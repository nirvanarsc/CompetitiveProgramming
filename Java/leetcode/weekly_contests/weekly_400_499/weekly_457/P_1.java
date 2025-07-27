package leetcode.weekly_contests.weekly_400_499.weekly_457;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P_1 {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        final List<String[]> res = new ArrayList<>();
        final Set<String> validBusinessLines = Set.of("electronics", "grocery", "pharmacy", "restaurant");
        final int n = code.length;
        for (int i = 0; i < n; i++) {
            if (f(code[i]) && validBusinessLines.contains(businessLine[i]) && isActive[i]) {
                res.add(new String[] { code[i], businessLine[i] });
            }
        }
        return res.stream()
                  .sorted((a, b) -> a[1].equals(b[1]) ?
                                    a[0].compareTo(b[0]) : a[1].compareTo(b[1]))
                  .map(u -> u[0])
                  .collect(Collectors.toList());
    }

    private static boolean f(String w) {
        for (char c : w.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                continue;
            }
            if ('A' <= c && c <= 'Z') {
                continue;
            }
            if ('0' <= c && c <= '9') {
                continue;
            }
            if (c != '_') {
                return false;
            }
        }
        return !w.isEmpty();
    }
}
