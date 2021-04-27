package binarysearch.weekly_48;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_3 {

    class LastValueMap {

        private class ListNode {
            int val;
            ListNode prev;
            ListNode next;

            ListNode(int val) {
                this.val = val;
            }
        }

        Map<Integer, ListNode> map;
        ListNode head = new ListNode(-1);
        ListNode tail = new ListNode(-1);

        LastValueMap() {
            map = new HashMap<>();
            head.next = tail;
            tail.prev = head;
        }

        public void set(int key, int value) {
            remove(key);
            final ListNode next = head.next;
            final ListNode add = new ListNode(value);
            head.next = add;
            next.prev = add;
            add.next = next;
            add.prev = head;
            map.put(key, add);
        }

        public void remove(int key) {
            final ListNode node = map.get(key);
            if (node == null) {
                return;
            }
            final ListNode prev = node.prev;
            final ListNode next = node.next;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                //noinspection ConstantConditions
                next.prev = prev;
            }
            map.remove(key);
        }

        public int getLast() {
            return head.next.val;
        }
    }
}
