@SuppressWarnings("ConstantConditions")
public final class ReversePrintImmutableLinkedList {

    private static final class ListNode<T> {
        public T data;
        public ListNode<T> next;

        private ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    // Can trade-off space for more loops (but still linear)
    // https://stackoverflow.com/questions/41542257/reverse-print-an-immutable-linked-list-with-less-than-on-space/41575182#41575182
    private static void reversePrint(ListNode<Integer> start, ListNode<Integer> end) {
        if (start == end) {
            return;
        }

        ListNode<Integer> slow;
        ListNode<Integer> fast;
        slow = fast = start;

        while (fast.next != end && fast.next.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        reversePrint(slow.next, end);
        System.out.println(slow.data);
        reversePrint(start, slow);
    }

    public static void main(String[] args) {
        ListNode<Integer> t = new ListNode<>(1, null);
        final ListNode<Integer> head = t;
        for (int i = 2; i <= 10; i++) {
            t.next = new ListNode<>(i, null);
            t = t.next;
        }
        reversePrint(head, null);
    }

    private ReversePrintImmutableLinkedList() {}
}
