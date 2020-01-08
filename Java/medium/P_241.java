package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class P_241 {
    private static final Pattern KEEP_DELIMITER = Pattern.compile("(?<=[+\\-*])|(?=[+\\-*])");
    private static final Pattern DIGITS = Pattern.compile("^[0-9]+$");

    public static List<Integer> diffWaysToCompute(String input) {
        return recurse(input, new HashMap<>());
    }

    private static List<Integer> recurse(String input, Map<String, List<Integer>> dp) {
        if (DIGITS.matcher(input).matches()) {
            return new ArrayList<>(Collections.singletonList(Integer.valueOf(input)));
        }
        if (dp.containsKey(input)) {
            return dp.get(input);
        }

        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                final String a = input.substring(0, i);
                final String b = input.substring(i + 1);
                final List<Integer> al = recurse(a, dp);
                final List<Integer> bl = recurse(b, dp);
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        dp.put(input, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(KEEP_DELIMITER.split("12+345-213123*111")));
        System.out.println(diffWaysToCompute("2-1-1"));
    }

    private P_241() {}
}
