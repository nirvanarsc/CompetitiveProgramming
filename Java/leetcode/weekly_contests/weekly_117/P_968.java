package leetcode.weekly_contests.weekly_117;

import utils.DataStructures.TreeNode;

public class P_968 {

    enum State {CAMERA, MONITORED, NOT_MONITORED}

    static class Status {
        int cameras;
        State state;

        Status(int cameras, State state) {
            this.cameras = cameras;
            this.state = state;
        }
    }

    public int minCameraCover(TreeNode root) {
        final Status status = getStatus(root);
        if (status.state == State.NOT_MONITORED) {
            status.cameras++;
        }
        return status.cameras;
    }

    private static Status getStatus(TreeNode node) {
        if (node == null) {
            return new Status(0, State.MONITORED);
        }

        final Status left = getStatus(node.left);
        final Status right = getStatus(node.right);
        final Status curr = new Status(left.cameras + right.cameras, State.NOT_MONITORED);

        if (left.state == State.NOT_MONITORED || right.state == State.NOT_MONITORED) {
            curr.cameras++;
            curr.state = State.CAMERA;
        } else if (left.state == State.CAMERA || right.state == State.CAMERA) {
            curr.state = State.MONITORED;
        }

        return curr;
    }
}
