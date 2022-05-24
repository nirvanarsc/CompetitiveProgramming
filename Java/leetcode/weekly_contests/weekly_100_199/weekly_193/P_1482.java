package leetcode.weekly_contests.weekly_100_199.weekly_193;

@SuppressWarnings("unused")
public class P_1482 {

    private static final class TreeAncestor {

        int h;
        int[][] parents;

        private TreeAncestor(int n, int[] parent) {
            h = (int) (Math.log(n) / Math.log(2));
            parents = new int[h + 1][n];
            parents[0] = parent;
            for (int i = 1; i <= h; i++) {
                for (int node = 0; node < n; node++) {
                    final int nodeParent = parents[i - 1][node];
                    if (nodeParent != -1) {
                        parents[i][node] = parents[i - 1][nodeParent];
                    } else {
                        parents[i][node] = -1;
                    }
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            for (int i = 0; i <= h; i++) {
                if ((k & (1 << i)) != 0) {
                    node = parents[i][node];
                    if (node == -1) { return -1; }
                }
            }
            return node;
        }
    }
}
