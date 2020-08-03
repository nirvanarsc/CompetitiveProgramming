package easy;

@SuppressWarnings("unused")
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
        private final ListNode[] nodes;

        MyHashMap() {
            nodes = new ListNode[10000];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new ListNode(-1, -1);
            }
        }

        public void put(int key, int value) {
            final int index = getIndex(key);
            final ListNode curr = find(key, nodes[index]);
            if (curr.next == null) {
                curr.next = new ListNode(key, value);
            } else {
                final ListNode temp = curr.next.next;
                curr.next = new ListNode(key, value);
                curr.next.next = temp;
            }
        }

        public int get(int key) {
            final int index = getIndex(key);
            final ListNode res = find(key, nodes[index]);
            return res.next == null ? -1 : res.next.val;
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
