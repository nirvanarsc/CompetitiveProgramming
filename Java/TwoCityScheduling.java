import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class TwoCityScheduling {

    static class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        final int[][] costs = {
                { 10, 20 },
                { 30, 200 },
                { 400, 50 },
                { 30, 20 }
        };
        System.out.println(twoCitySchedCost(costs));
        System.out.println(twoCitySchedCost2(costs));
    }

    public static int twoCitySchedCost(int[][] costs) {
        final List<Pair> list = new ArrayList<>();
        int res = 0;
        int idx = 0;
        for (int[] line : costs) {
            list.add(new Pair(idx++, line[0] - line[1]));
        }
        list.sort(Comparator.comparingInt(a -> a.value));
        idx = 0;
        for (Pair p : list) {
            res += costs[p.index][idx++ < costs.length / 2 ? 0 : 1];
        }

        return res;
    }

    // DP
    public static int twoCitySchedCost2(int[][] costs) {
        final int N = costs.length / 2;
        final int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int j = 1; j <= N; j++) {
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return dp[N][N];
    }

    private TwoCityScheduling() {}
}
