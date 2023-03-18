package leetcode.biweekly_contests.biweekly_0_99.biweekly_67;

import java.util.TreeSet;

@SuppressWarnings({
        "ConstantConditions",
        "ComparableImplementedButEqualsNotOverridden",
        "PublicConstructorInNonPublicClass",
        "InnerClassMayBeStatic",
        "unused"
})
public class P_4 {

    class SORTracker {

        private class Pair implements Comparable<Pair> {
            String name;
            int score;

            Pair(String name, int score) {
                this.name = name;
                this.score = score;
            }

            @Override
            public int compareTo(Pair o) {
                return score == o.score ? name.compareTo(o.name)
                                        : Integer.compare(o.score, score);
            }
        }

        TreeSet<Pair> ts;
        Pair curr;

        public SORTracker() {
            ts = new TreeSet<>();
        }

        public void add(String name, int score) {
            final Pair p = new Pair(name, score);
            ts.add(p);
            if (curr == null) {
                curr = ts.last();
            } else if (p.compareTo(curr) < 0) {
                curr = ts.lower(curr);
            }
        }

        public String get() {
            final String res = curr.name;
            curr = ts.higher(curr);
            return res;
        }
    }
}
