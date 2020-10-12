package leetcode.easy;

@SuppressWarnings("unused")
public class P_705 {

    private static class ListNode {
        int key;
        ListNode next;

        ListNode(int key) {
            this.key = key;
        }
    }

    static class MyHashSet {
        private final ListNode[] nodes;

        MyHashSet() {
            nodes = new ListNode[10000];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new ListNode(-1);
            }
        }

        public void add(int key) {
            final int index = getIndex(key);
            final ListNode curr = find(key, nodes[index]);
            if (curr.next != null) {
                return;
            }
            curr.next = new ListNode(key);
        }

        public boolean contains(int key) {
            final int index = getIndex(key);
            return find(key, nodes[index]).next != null;
        }

        public void remove(int key) {
            final int index = getIndex(key);
            ListNode curr = nodes[index];
            curr = find(key, curr);
            if (curr.next != null) {
                curr.next = curr.next.next;
            }
        }

        private static ListNode find(int key, ListNode curr) {
            while (curr.next != null && curr.next.key != key) {
                curr = curr.next;
            }
            return curr;
        }

        private int getIndex(int key) {
            return Integer.hashCode(key) % nodes.length;
        }
    }
}
