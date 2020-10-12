package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class P_432 {

    static class Node {
        Node prev, next;
        Set<String> set;
        int val;

        Node(int val) {
            this.val = val;
            set = new HashSet<>();
        }
    }

    static class AllOne {
        Node head, tail;
        Map<String, Integer> keyMap;
        Map<Integer, Node> countMap;

        AllOne() {
            head = new Node(Integer.MIN_VALUE);
            tail = new Node(Integer.MAX_VALUE);
            head.next = tail;
            tail.prev = head;
            keyMap = new HashMap<>();
            countMap = new HashMap<>();
        }

        public void inc(String key) {
            if (keyMap.containsKey(key)) {
                changeKey(key, 1);
            } else {
                keyMap.put(key, 1);
                if (head.next.val != 1) {
                    addAfter(new Node(1), head);
                }
                head.next.set.add(key);
                countMap.put(1, head.next);
            }
        }

        public void dec(String key) {
            if (!keyMap.containsKey(key)) {
                return;
            }
            final int count = keyMap.get(key);
            if (count == 1) {
                keyMap.remove(key);
                removeKey(key, countMap.get(1));
            } else {
                changeKey(key, -1);
            }
        }

        public String getMaxKey() {
            if (tail.prev == head) {
                return "";
            }
            return tail.prev.set.iterator().next();
        }

        public String getMinKey() {
            if (head.next == tail) {
                return "";
            }
            return head.next.set.iterator().next();
        }

        private void changeKey(String key, int offSet) {
            final int count = keyMap.get(key);
            keyMap.put(key, count + offSet);
            final Node cur = countMap.get(count);
            Node next = countMap.get(count + offSet);
            if (next == null) {
                next = new Node(count + offSet);
                addAfter(next, offSet > 0 ? cur : cur.prev);
                countMap.put(count + offSet, next);
            }
            next.set.add(key);
            removeKey(key, cur);
        }

        private static void addAfter(Node node, Node prev) {
            node.next = prev.next;
            node.prev = prev;
            prev.next.prev = node;
            prev.next = node;
        }

        private void removeKey(String key, Node node) {
            node.set.remove(key);
            if (node.set.isEmpty()) {
                node.next.prev = node.prev;
                node.prev.next = node.next;
                countMap.remove(node.val);
            }
        }
    }
}
