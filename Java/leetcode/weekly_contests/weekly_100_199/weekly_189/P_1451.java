package leetcode.weekly_contests.weekly_100_199.weekly_189;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P_1451 {

    static class Pair {
        String s;
        int i;

        Pair(String s, int i) {
            this.s = s;
            this.i = i;
        }
    }

    public String arrangeWords(String text) {
        final String[] s = text.toLowerCase().split(" ");
        final List<Pair> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            list.add(new Pair(s[i], i));
        }
        list.sort((a, b) -> a.s.length() == b.s.length() ? Integer.compare(a.i, b.i)
                                                         : Integer.compare(a.s.length(), b.s.length()));
        final String res = list.stream().map(x -> x.s).collect(Collectors.joining(" "));
        return Character.toUpperCase(res.charAt(0)) + res.substring(1);
    }

    public String arrangeWordsSmart(String text) {
        final String[] s = text.toLowerCase().split(" ");
        Arrays.sort(s, Comparator.comparingInt(String::length));
        final String res = String.join(" ", s);
        return Character.toUpperCase(res.charAt(0)) + res.substring(1);
    }
}
