package easy;

@SuppressWarnings("unused")
public class P_705 {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static class MyHashSet {
        private final Node[] nodes;
        private final int len;

        MyHashSet() {
            len = 10000;
            nodes = new Node[len];
            for (int i = 0; i < len; i++) {
                nodes[i] = new Node(-1);
            }
        }

        public void add(int key) {
            final int index = key % len;
            Node curr = nodes[index];
            if (curr == null) {
                nodes[index] = new Node(key);
            } else {
                curr = getNode(key, curr);
                if (curr.next != null) {
                    return;
                }
                curr.next = new Node(key);
            }
        }

        public void remove(int key) {
            final int index = key % len;
            Node curr = nodes[index];
            curr = getNode(key, curr);
            if (curr.next != null) {
                curr.next = curr.next.next;
            }
        }

        public boolean contains(int key) {
            final int index = key % len;
            Node curr = nodes[index];
            curr = getNode(key, curr);
            return curr.next != null;
        }

        private static Node getNode(int key, Node curr) {
            while (curr.next != null && curr.next.val != key) {
                curr = curr.next;
            }
            return curr;
        }
    }
}
