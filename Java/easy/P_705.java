package easy;

@SuppressWarnings("unused")
public class P_705 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
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
            ListNode curr = nodes[index];
            if (curr == null) {
                nodes[index] = new ListNode(key);
            } else {
                curr = find(key, curr);
                if (curr.next != null) {
                    return;
                }
                curr.next = new ListNode(key);
            }
        }

        public void remove(int key) {
            final int index = getIndex(key);
            ListNode curr = nodes[index];
            curr = find(key, curr);
            if (curr.next != null) {
                curr.next = curr.next.next;
            }
        }

        public boolean contains(int key) {
            final int index = getIndex(key);
            ListNode curr = nodes[index];
            curr = find(key, curr);
            return curr.next != null;
        }

        private static ListNode find(int key, ListNode curr) {
            while (curr.next != null && curr.next.val != key) {
                curr = curr.next;
            }
            return curr;
        }

        private int getIndex(int key) {
            return Integer.hashCode(key) % nodes.length;}
    }
}
