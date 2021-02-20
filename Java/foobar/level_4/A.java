package foobar.level_4;

import java.util.Arrays;
import java.util.stream.IntStream;

@SuppressWarnings("UtilityClassWithoutPrivateConstructor")
public final class A {

    // Helper class that generates all combinations for n choose k in lexicographical order.
    private static class CombinationIterator {
        int n;
        int k;
        int[] combination;

        CombinationIterator(int n, int k) {
            this.n = n;
            this.k = k;
            combination = IntStream.range(0, k).toArray();
        }

        @SuppressWarnings("ConstantConditions")
        public int[] next() {
            final int[] res = combination.clone();
            combination = nextCombination(combination, n, k);
            return res;
        }

        public boolean hasNext() {
            return combination != null;
        }

        @SuppressWarnings("ReturnOfNull")
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

    public static int[][] solution(int num_buns, int num_required) {
        // Number of times each key must appear.
        // Since the condition is that any (num_required - 1) bunnies are unable to open all the doors,
        // we need to make each key be available exactly (num_buns - (num_required - 1)) times.
        // By doing so, due to pigeonhole principle if we have picked (num_required - 1) bunnies that lack
        // some key x (worst case scenario), each of the remaining bunnies (num_buns - (num_required - 1))
        // carry key x and therefore our last choice for a bunny will have the key x.
        final int k = num_buns - (num_required - 1);
        final int totalCombinations = nCk(num_buns, k);
        final int keysPerBunny = (totalCombinations * k) / num_buns;

        final int[][] res = new int[num_buns][keysPerBunny];
        final int[] indices = new int[num_buns];

        final CombinationIterator ci = new CombinationIterator(num_buns, k);
        for (int i = 0; ci.hasNext(); i++) {
            for (int num : ci.next()) {
                res[num][indices[num]++] = i;
            }
        }
        return res;
    }

    private static int nCk(int n, int k) {
        int up = 1;
        int down = 1;
        final int kCopy = k;
        for (int i = 0; i < kCopy; i++) {
            up *= n;
            down *= k;
            n--;
            k--;
        }
        return up / down;
    }

    public static void main(String[] args) {
        print(solution(5, 3));
        print(solution(2, 1));
        print(solution(2, 2));
        print(solution(3, 1));
        print(solution(3, 2));
        print(solution(4, 4));
        print(solution(9, 3));
    }

    private static void print(int[][] d) {
        for (int[] row : d) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
