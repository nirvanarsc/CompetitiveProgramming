package leetcode.medium;

public class P_427 {

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
        }

        Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length);
    }

    private static Node dfs(int[][] grid, int x, int y, int len) {
        if (len == 1) {
            return new Node(grid[x][y] == 1, true);
        }
        final Node topLeft = dfs(grid, x, y, len / 2);
        final Node topRight = dfs(grid, x, y + len / 2, len / 2);
        final Node botLeft = dfs(grid, x + len / 2, y, len / 2);
        final Node botRight = dfs(grid, x + len / 2, y + len / 2, len / 2);
        if (topLeft.isLeaf && topRight.isLeaf && botLeft.isLeaf && botRight.isLeaf &&
            topLeft.val == topRight.val && topRight.val == botLeft.val && botLeft.val == botRight.val) {
            return new Node(topLeft.val, true);
        }
        return new Node(grid[x][y] == 1, false, topLeft, topRight, botLeft, botRight);
    }
}
