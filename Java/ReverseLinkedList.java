import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.jetbrains.annotations.Nullable;

public final class ReverseLinkedList {

    public static class ListNode {
        int val;
        @Nullable ListNode next;

        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        final List<ListNode> list = IntStream.rangeClosed(1, 5)
                                             .mapToObj(ListNode::new)
                                             .collect(Collectors.toList());
        int i = 0;
        while (i < list.size() - 1) {
            list.get(i).next = list.get(++i);
        }

        final ListNode head = list.get(0);
        printList(head);
        final ListNode reversed = reverseList(head);
        printList(reversed);

    }

    // Iterative
    public static @Nullable ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null) {
            final ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    // Recursive
    public static @Nullable ListNode reverseListR(ListNode head) {
        return reverseListR(head, null);
    }

    private static @Nullable ListNode reverseListR(@Nullable ListNode head, @Nullable ListNode newHead) {
        if (head == null) { return newHead; }
        final ListNode next = head.next;
        head.next = newHead;
        return reverseListR(next, head);
    }

    private static void printList(@Nullable ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    private ReverseLinkedList() {}
}
