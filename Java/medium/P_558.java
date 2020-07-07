package medium;

public class P_558 {

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

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;
        }
        if (quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;
        }

        final Node topL = intersect(quadTree1.topLeft, quadTree2.topLeft);
        final Node topR = intersect(quadTree1.topRight, quadTree2.topRight);
        final Node botL = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        final Node botR = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

        if (topL.isLeaf && topR.isLeaf && botL.isLeaf && botR.isLeaf &&
            topL.val == topR.val && topR.val == botL.val && botL.val == botR.val) {
            return new Node(topL.val, true);
        }
        return new Node(topL.val, false, topL, topR, botL, botR);
    }
}
