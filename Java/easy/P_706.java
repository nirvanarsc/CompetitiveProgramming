package easy;

@SuppressWarnings({ "unused", "ConstantConditions" })
public class P_706 {

    private static class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class MyHashMap {
        final ListNode[] nodes = new ListNode[10000];

        public void put(int key, int value) {
            final int index = getIndex(key);
            if (nodes[index] == null) {
                nodes[index] = new ListNode(-1, -1);
            }
            final ListNode prev = find(key, nodes[index]);
            if (prev.next == null) {
                prev.next = new ListNode(key, value);
            } else {
                prev.next.val = value;
            }
        }

        public int get(int key) {
            final int index = getIndex(key);
            if (nodes[index] == null) {
                return -1;
            }
            final ListNode node = find(key, nodes[index]);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int key) {
            final int index = getIndex(key);
            if (nodes[index] == null) {
                return;
            }
            final ListNode prev = find(key, nodes[index]);
            if (prev.next == null) {
                return;
            }
            prev.next = prev.next.next;
        }

        private static ListNode find(int key, ListNode bucket) {
            ListNode node = bucket, prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }

        private int getIndex(int key) {
            return Integer.hashCode(key) % nodes.length;
        }
    }
}
