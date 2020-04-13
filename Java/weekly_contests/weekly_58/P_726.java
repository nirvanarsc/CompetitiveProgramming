package weekly_contests.weekly_58;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class P_726 {

    public String countOfAtoms(String formula) {
        final String reverse = new StringBuilder(formula).reverse().toString();
        final Map<String, Integer> map = new HashMap<>();
        compute(reverse, map);
        return map.keySet()
                  .stream()
                  .sorted()
                  .map(key -> map.get(key) == 1 ? key : key + map.get(key))
                  .collect(Collectors.joining());
    }

    private static void compute(String formula, Map<String, Integer> map) {
        final Deque<Integer> stack = new ArrayDeque<>(Collections.singleton(1));
        final StringBuilder elem = new StringBuilder();
        int factor = 1;
        for (int i = 0; i < formula.length(); ++i) {
            char c = formula.charAt(i);
            if (Character.isDigit(c)) {
                int val = 0, expo = 1;
                do {
                    val += (c - '0') * expo;
                    expo *= 10;
                    c = formula.charAt(++i);
                } while (Character.isDigit(c));
                factor = val;
                i -= 1;
            } else if (c == ')') {
                stack.addFirst(factor * stack.element());
                factor = 1;
            } else if (Character.isUpperCase(c)) {
                elem.append(c);
                elem.reverse();
                map.merge(elem.toString(), factor * stack.element(), Integer::sum);
                factor = 1;
                elem.setLength(0);
            } else if (Character.isLowerCase(c)) {
                elem.append(c);
            } else {
                stack.removeFirst();
            }
        }
    }
}
