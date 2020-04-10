package weekly_contests.weekly_60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_736 {

    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }

    @SuppressWarnings("TailRecursion")
    private static int eval(String exp, Map<String, Integer> parent) {
        if (exp.charAt(0) != '(') {
            if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-') {
                return Integer.parseInt(exp);
            }
            return parent.get(exp);
        }
        final Map<String, Integer> map = new HashMap<>(parent);
        final List<String> tokens = parse(exp.substring(exp.charAt(1) == 'm' ? 6 : 5, exp.length() - 1));
        if (exp.startsWith("(add")) {
            return eval(tokens.get(0), map) + eval(tokens.get(1), map);
        } else if (exp.startsWith("(mult")) {
            return eval(tokens.get(0), map) * eval(tokens.get(1), map);
        } else {
            for (int i = 0; i < tokens.size() - 2; i += 2) {
                map.put(tokens.get(i), eval(tokens.get(i + 1), map));
            }
            return eval(tokens.get(tokens.size() - 1), map);
        }
    }

    private static List<String> parse(String str) {
        final List<String> res = new ArrayList<>();
        int par = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') { par++; }
            if (c == ')') { par--; }
            if (par == 0 && c == ' ') {
                res.add(new String(sb));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            res.add(new String(sb));
        }
        return res;
    }
}
