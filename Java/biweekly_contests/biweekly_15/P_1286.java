package biweekly_contests.biweekly_15;

import java.util.List;

import medium.P_77;

public final class P_1286 {

    static class CombinationIterator {
        String word;
        List<List<Integer>> combinations;
        int idx;

        CombinationIterator(String characters, int combinationLength) {
            word = characters;
            combinations = P_77.combine(characters.length(), combinationLength);
            idx = 0;
        }

        public String next() {
            final List<Integer> integers = combinations.get(idx);
            final StringBuilder sb = new StringBuilder();
            for (int i : integers) {
                sb.append(word.charAt(i - 1));
            }
            idx++;
            return sb.toString();
        }

        public boolean hasNext() {
            return idx != combinations.size();
        }
    }

    public static void main(String[] args) {
        final CombinationIterator cbi = new CombinationIterator("abc", 2);

        while (cbi.hasNext()) {
            System.out.println(cbi.next());
        }
    }
}
