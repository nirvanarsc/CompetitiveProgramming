package hard;

public class P_1220 {

    private static final int MOD = (int) (1e9 + 7);

    public int countVowelPermutation(int n) {
        final int[][] graph = { { 1 }, { 0, 2 }, { 0, 1, 3, 4 }, { 2, 4 }, { 0 } };
        int cnt = 0;
        final Integer[][] memo = new Integer[n + 1][5];
        for (int i = 0; i < graph.length; i++) {
            cnt += helper(n - 1, i, graph, memo);
            cnt %= MOD;
        }
        return cnt;
    }

    private static int helper(int n, int cur, int[][] graph, Integer[][] memo) {
        if (n == 0) {
            return 1;
        }
        if (memo[n][cur] != null) {
            return memo[n][cur];
        }
        int cnt = 0;
        for (int neighbour : graph[cur]) {
            cnt += helper(n - 1, neighbour, graph, memo);
            cnt %= MOD;
        }
        return memo[n][cur] = cnt;
    }
}
