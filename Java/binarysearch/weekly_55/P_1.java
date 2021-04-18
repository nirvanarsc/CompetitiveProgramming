package binarysearch.weekly_55;

public class P_1 {

    private static class LLNode {
        int val;
        LLNode next;
    }

    public LLNode solve(LLNode head, int pos, int val) {
        final LLNode dummy = new LLNode();
        dummy.next = head;
        LLNode iter = dummy;
        for (int i = 0; i < pos; i++) {
            iter = iter.next;
        }
        final LLNode temp = iter.next;
        final LLNode insert = new LLNode();
        insert.val = val;
        iter.next = insert;
        insert.next = temp;
        return dummy.next;
    }
}
