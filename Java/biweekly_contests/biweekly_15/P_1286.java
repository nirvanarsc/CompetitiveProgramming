package biweekly_contests.biweekly_15;

import java.util.stream.IntStream;

@SuppressWarnings({ "ConstantConditions", "ReturnOfNull", "unused" })
public class P_1286 {

    static class CombinationIterator {
        String word;
        int[] combination;

        CombinationIterator(String characters, int combinationLength) {
            word = characters;
            combination = IntStream.range(0, combinationLength).toArray();
        }

        public String next() {
            final StringBuilder sb = new StringBuilder();
            for (int idx : combination) {
                sb.append(word.charAt(idx));
            }
            combination = nextCombination(combination, word.length(), combination.length);
            return sb.toString();
        }

        public boolean hasNext() {
            return combination != null;
        }

        private static int[] nextCombination(int[] curr, int n, int k) {
            if (curr[k - 1] < n - 1) {
                curr[k - 1]++;
                return curr;
            }
            int idx = k - 1;
            while (idx > 0 && curr[idx] == curr[idx - 1] + 1) {
                idx--;
            }
            if (idx == 0) {
                return null;
            }
            idx--;
            curr[idx]++;
            for (int i = idx + 1; i < k; i++) {
                curr[i] = curr[i - 1] + 1;
            }
            return curr;
        }
    }
}
