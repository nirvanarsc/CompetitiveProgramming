package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class P_146 {

    static class LRUCacheLHM {
        Map<Integer, Integer> cache;

        LRUCacheLHM(int capacity) {
            cache = new LinkedHashMap<>(capacity, 0.75f, true) {
                private static final long serialVersionUID = 316458002587273807L;

                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }

    static class LRUCache {

        static class ListNode {
            ListNode prev;
            ListNode next;
            int key;
            int val;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }

            static void moveToHead(ListNode node, ListNode head) {
                removeNode(node);
                addNode(node, head);
            }

            static void addNode(ListNode node, ListNode head) {
                node.prev = head;
                node.next = head.next;

                head.next.prev = node;
                head.next = node;
            }

            static ListNode popTail(ListNode tail) {
                final ListNode prev = tail.prev;
                removeNode(prev);
                return prev;
            }

            static void removeNode(ListNode node) {
                final ListNode prev = node.prev;
                final ListNode next = node.next;

                prev.next = next;
                next.prev = prev;
            }
        }

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode head = new ListNode(-1, -1);
        ListNode tail = new ListNode(-1, -1);
        int capacity;
        int size;

        LRUCache(int capacity) {
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
        }

        public int get(int key) {
            final ListNode listNode = map.get(key);
            if (listNode == null) {
                return -1;
            }

            ListNode.moveToHead(listNode, head);
            return listNode.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                final ListNode listNode = map.get(key);
                listNode.val = value;
                ListNode.moveToHead(listNode, head);
            } else {
                if (size == capacity) {
                    final ListNode listNode = ListNode.popTail(tail);
                    map.remove(listNode.key);
                    size--;
                }

                final ListNode listNode = new ListNode(key, value);
                ListNode.addNode(listNode, head);
                map.put(key, listNode);
                size++;
            }
        }
    }
}
