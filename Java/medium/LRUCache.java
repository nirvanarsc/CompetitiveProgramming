package medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private static class ListNode {
        ListNode prev;
        ListNode next;
        int key;
        int val;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, ListNode> map = new HashMap<>();
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);
    int size;
    int capacity;

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        final ListNode listNode = map.get(key);
        if (listNode == null) {
            return -1;
        }

        moveToHead(listNode);
        return listNode.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            final ListNode listNode = map.get(key);
            listNode.val = value;
            moveToHead(listNode);
        } else {
            if (size == capacity) {
                final ListNode listNode = popTail();
                map.remove(listNode.key);
                size--;
            }

            final ListNode listNode = new ListNode(key, value);
            addNode(listNode);
            map.put(key, listNode);
            size++;
        }
    }

    ListNode popTail() {
        final ListNode res = tail.prev;
        removeNode(res);
        return res;
    }

    void moveToHead(ListNode node) {
        removeNode(node);
        addNode(node);
    }

    void addNode(ListNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    void removeNode(ListNode node) {
        final ListNode prev = node.prev;
        final ListNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }
}

//class LRUCache extends LinkedHashMap<Integer, Integer>{
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        super(capacity, 0.75F, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return super.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        super.put(key, value);
//    }
//
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        return size() > capacity;
//    }
//}
