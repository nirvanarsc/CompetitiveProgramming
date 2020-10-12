package leetcode.weekly_contests.weekly_68;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class P_770 {

    static class Term implements Comparable<Term> {
        int coef;
        List<String> vars;

        Term(int n) {
            vars = new ArrayList<>();
            coef = n;
        }

        Term(String s) {
            vars = new ArrayList<>(Collections.singleton(s));
            coef = 1;
        }

        @Override
        public String toString() {
            return coef + varString();
        }

        private String varString() {
            Collections.sort(vars);
            final StringBuilder sb = new StringBuilder();
            for (String s : vars) {
                sb.append('*');
                sb.append(s);
            }
            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Term) {
                return varString().equals(((Term) o).varString());
            }
            return false;
        }

        @Override
        public int compareTo(Term t) {
            if (vars.size() != t.vars.size()) {
                return Integer.compare(t.vars.size(), vars.size());
            }
            return varString().compareTo(t.varString());
        }

        public Term multi(Term t) {
            final Term result = new Term(coef);
            result.vars.addAll(vars);
            result.coef *= t.coef;
            result.vars.addAll(t.vars);
            return result;
        }

        @Override
        public int hashCode() {
            return Objects.hash(coef, vars);
        }
    }

    static class Sequence {
        List<Term> terms;

        Sequence() {
            terms = new ArrayList<>();
        }

        Sequence(int n) {
            terms = new ArrayList<>();
            terms.add(new Term(n));
        }

        Sequence(String s) {
            terms = new ArrayList<>(Collections.singleton(new Term(s)));
        }

        Sequence(Term t) {
            terms = new ArrayList<>(Collections.singleton(t));
        }

        public Sequence add(Sequence sq) {
            for (Term t2 : sq.terms) {
                boolean found = false;
                for (Term t1 : terms) {
                    if (t1.equals(t2)) {
                        t1.coef += t2.coef;
                        if (t1.coef == 0) {
                            terms.remove(t1);
                        }
                        found = true;
                        break;
                    }
                }
                if (!found && t2.coef != 0) {
                    terms.add(t2);
                }
            }
            return this;
        }

        public Sequence multi(Sequence sq) {
            final Sequence result = new Sequence();
            for (Term t1 : terms) {
                for (Term t2 : sq.terms) {
                    result.add(new Sequence(t1.multi(t2)));
                }
            }
            return result;
        }
    }

    private int i;

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            map.put(evalvars[i], evalints[i]);
        }
        i = 0;
        final Sequence sq = helper(expression, map);
        final List<String> result = new LinkedList<>();
        Collections.sort(sq.terms);
        for (Term t : sq.terms) {
            if (!"0".equals(t.toString())) {
                result.add(t.toString());
            }
        }
        return result;
    }

    private Sequence helper(String e, Map<String, Integer> map) {
        final Deque<Sequence> stack = new ArrayDeque<>(Collections.singleton(new Sequence(0)));
        int flag = 1;
        while (i < e.length()) {
            if (e.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (e.charAt(i) == '(') {
                i++;
                final Sequence sq = helper(e, map);
                addToStack(stack, sq, flag);
            } else if (e.charAt(i) == ')') {
                break;
            } else if (e.charAt(i) == '+') {
                flag = 1;
            } else if (e.charAt(i) == '-') {
                flag = -1;
            } else if (e.charAt(i) == '*') {
                flag = 0;
            } else if (Character.isDigit(e.charAt(i))) {
                int j = i + 1;
                while (j < e.length() && Character.isDigit(e.charAt(j))) {
                    j++;
                }
                final int coef = Integer.valueOf(e.substring(i, j));
                i = j - 1;
                addToStack(stack, new Sequence(coef), flag);
            } else {
                int j = i + 1;
                while (j < e.length() && e.charAt(j) != ' ' && e.charAt(j) != ')') {
                    j++;
                }
                final String var = e.substring(i, j);
                i = j - 1;
                if (map.containsKey(var)) {
                    addToStack(stack, new Sequence(map.get(var)), flag);
                } else {
                    addToStack(stack, new Sequence(var), flag);
                }
            }
            i++;
        }
        final Sequence result = new Sequence();
        while (!stack.isEmpty()) {
            result.add(stack.removeFirst());
        }
        return result;
    }

    private static void addToStack(Deque<Sequence> stack, Sequence sq, int flag) {
        if (flag == 0) {
            stack.addFirst(stack.removeFirst().multi(sq));
        } else {
            stack.addFirst(sq.multi(new Sequence(flag)));
        }
    }
}
