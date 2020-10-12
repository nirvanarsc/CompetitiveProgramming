package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_692 {

    public List<String> topKFrequent(String[] words, int k) {
        final Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        final PriorityQueue<String> pq =
                new PriorityQueue<>((a, b) -> map.get(a).equals(map.get(b))
                                              ? b.compareTo(a)
                                              : Integer.compare(map.get(a), map.get(b)));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry.getKey());
            if (pq.size() > k) {
                pq.remove();
            }
        }
        final List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        Collections.reverse(res);
        return res;
    }
}
