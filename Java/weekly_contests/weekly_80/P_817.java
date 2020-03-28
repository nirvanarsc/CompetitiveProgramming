package weekly_contests.weekly_80;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import utils.DataStructures.ListNode;
import utils.DataStructures.UnionFind;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_817 {

    public int numComponents(ListNode head, int[] G) {
        final Map<Integer, Integer> s = new HashMap<>();
        for (int i = 0; i < G.length; i++) {
            s.put(G[i], i);
        }
        final UnionFind uf = new UnionFind(G.length);
        ListNode prev = head;
        head = head.next;
        while (head != null) {
            if (s.containsKey(prev.val) && s.containsKey(head.val)) {
                uf.union(s.get(prev.val), s.get(head.val));
            }
            prev = prev.next;
            head = head.next;
        }
        return uf.count();
    }

    public int numComponentsSet(ListNode head, int[] G) {
        final Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int res = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                res++;
            }
            head = head.next;
        }
        return res;
    }
}
